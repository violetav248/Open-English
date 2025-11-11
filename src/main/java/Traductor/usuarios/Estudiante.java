package Traductor.usuarios;

import Traductor.diccionario.Diccionario;

import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Usuario {
    private final List<RegistroBusqueda> historial = new ArrayList<>();
    public Estudiante(String nombreCompleto, String numDocumento, String tipoDocumento,
                      String nomUsuario, String contrasena) {
        super(nombreCompleto, numDocumento, tipoDocumento, nomUsuario, contrasena);
    }
    public String buscarPalabra(Diccionario diccionario, String palabra, String idioma) {
        String resultado = diccionario.traducirPalabra(palabra, idioma);
        boolean encontrada = resultado != null;
        registrarBusqueda(palabra, idioma, resultado, encontrada);
        return resultado;
    }
    public void registrarBusqueda(String palabra, String idioma, String resultado, boolean encontrada) {
        historial.add(new RegistroBusqueda(palabra, idioma, resultado, encontrada));
    }
    public List<String> verificarHistorial() {
        return historial.stream().map(RegistroBusqueda::mostrarRegistro).toList();
    }
    public List<RegistroBusqueda> getHistorial() {
        return List.copyOf(historial);
    }
}