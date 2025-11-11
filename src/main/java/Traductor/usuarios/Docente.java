package Traductor.usuarios;

import Traductor.diccionario.Diccionario;
import Traductor.diccionario.Palabra;

public class Docente extends Usuario {
    public Docente(String nombreCompleto, String numDocumento, String tipoDocumento,
                   String nomUsuario, String contrasena) {
        super(nombreCompleto, numDocumento, tipoDocumento, nomUsuario, contrasena);
    }
    public void agregarPalabra(Diccionario diccionario, String espanol, String ingles) {
        diccionario.agregarPalabra(new Palabra(espanol, ingles));
    }
    public void eliminarPalabra(Diccionario diccionario, String palabra) {
        diccionario.eliminarPalabra(palabra);
    }
    public String informeDiccionario(Diccionario diccionario) {
        StringBuilder sb = new StringBuilder("=== Informe Diccionario ===\n");
        diccionario.mostrarPalabras().forEach(line -> sb.append(line).append("\n"));
        var masBuscada = diccionario.palabraMasBuscada();
        if (masBuscada != null) {
            sb.append("Palabra más buscada: ").append(masBuscada.mostrarPalabra()).append("\n");
        }
        return sb.toString();
    }
}