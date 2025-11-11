package Traductor.usuarios;

import java.time.LocalDateTime;

public class RegistroBusqueda {
    private final LocalDateTime fecha;
    private final String palabraBuscada;
    private final String idioma; // ES / EN
    private final String resultado;
    private final boolean encontrada;
    public RegistroBusqueda(String palabraBuscada, String idioma, String resultado, boolean encontrada) {
        this.fecha = LocalDateTime.now();
        this.palabraBuscada = palabraBuscada;
        this.idioma = idioma;
        this.resultado = resultado;
        this.encontrada = encontrada;
    }
    public RegistroBusqueda(LocalDateTime fecha, String palabraBuscada, String idioma, String resultado, boolean encontrada) {
        this.fecha = fecha;
        this.palabraBuscada = palabraBuscada;
        this.idioma = idioma;
        this.resultado = resultado;
        this.encontrada = encontrada;
    }
    public String mostrarRegistro() {
        return String.format("%s;'%s';%s;%s;'%%s'", 
                fecha, palabraBuscada, idioma, encontrada, resultado == null ? "" : resultado);
    }
    public LocalDateTime getFecha() { return fecha; }
    public String getPalabraBuscada() { return palabraBuscada; }
    public String getIdioma() { return idioma; }
    public String getResultado() { return resultado; }
    public boolean isEncontrada() { return encontrada; }
}