package Traductor.diccionario;

public class Palabra {
    private final String espanol;
    private final String ingles;
    private int contadorBusquedas;
    public Palabra(String espanol, String ingles) {
        this.espanol = espanol;
        this.ingles = ingles;
        this.contadorBusquedas = 0;
    }
    public void incrementarContador() { contadorBusquedas++; }
    public String mostrarPalabra() {
        return String.format("ES: %s | EN: %s (busquedas=%d)", espanol, ingles, contadorBusquedas);
    }
    public String getEspanol() { return espanol; }
    public String getIngles() { return ingles; }
    public int getContadorBusquedas() { return contadorBusquedas; }
}