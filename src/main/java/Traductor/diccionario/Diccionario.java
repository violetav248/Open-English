package Traductor.diccionario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Diccionario {
    private final List<Palabra> listaPalabras = new ArrayList<>();
    public boolean agregarPalabra(Palabra palabra) {
        if (palabra == null) return false;
        boolean existe = listaPalabras.stream().anyMatch(p ->
                p.getEspanol().equalsIgnoreCase(palabra.getEspanol()) ||
                p.getIngles().equalsIgnoreCase(palabra.getIngles()));
        if (!existe) {
            listaPalabras.add(palabra);
            return true;
        }
        return false;
    }
    public boolean eliminarPalabra(String palabra) {
        if (palabra == null) return false;
        return listaPalabras.removeIf(p ->
                p.getEspanol().equalsIgnoreCase(palabra) ||
                p.getIngles().equalsIgnoreCase(palabra));
    }
    public String buscarPalabra(String palabra, String idioma) {
        Optional<Palabra> opt = listaPalabras.stream().filter(p ->
                ("ES".equalsIgnoreCase(idioma) && p.getEspanol().equalsIgnoreCase(palabra)) ||
                ("EN".equalsIgnoreCase(idioma) && p.getIngles().equalsIgnoreCase(palabra))
        ).findFirst();
        if (opt.isPresent()) {
            Palabra p = opt.get();
            p.incrementarContador();
            return "ES".equalsIgnoreCase(idioma) ? p.getIngles() : p.getEspanol();
        }
        return null;
    }
    public String traducirPalabra(String palabra, String idioma) {
        return buscarPalabra(palabra, idioma);
    }
    public List<String> mostrarPalabras() {
        return listaPalabras.stream().map(Palabra::mostrarPalabra).toList();
    }
    public Palabra palabraMasBuscada() {
        return listaPalabras.stream()
                .max(Comparator.comparingInt(Palabra::getContadorBusquedas))
                .orElse(null);
    }
    public List<Palabra> getPalabras() { return Collections.unmodifiableList(listaPalabras); }
    public void clear() { listaPalabras.clear(); }
}