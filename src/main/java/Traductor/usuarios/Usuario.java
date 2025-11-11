package Traductor.usuarios;

public abstract class Usuario {
    protected String nombreCompleto;
    protected String numDocumento;
    protected String tipoDocumento;
    protected String nomUsuario;
    protected String contrasena;
    public Usuario(String nombreCompleto,
                   String numDocumento,
                   String tipoDocumento,
                   String nomUsuario,
                   String contrasena) {
        this.nombreCompleto = nombreCompleto;
        this.numDocumento = numDocumento;
        this.tipoDocumento = tipoDocumento;
        this.nomUsuario = nomUsuario;
        this.contrasena = contrasena;
    }
    public boolean verificarContrasena(String password) {
        return contrasena != null && contrasena.equals(password);
    }
    public String mostrarInfo() {
        return String.format("Usuario: %s (%s %s) username=%s",
                nombreCompleto, tipoDocumento, numDocumento, nomUsuario);
    }
    public void actualizarDatos(String nuevoNombre, String nuevoTipoDoc, String nuevoNumDoc) {
        if (nuevoNombre != null && !nuevoNombre.isBlank()) this.nombreCompleto = nuevoNombre;
        if (nuevoTipoDoc != null && !nuevoTipoDoc.isBlank()) this.tipoDocumento = nuevoTipoDoc;
        if (nuevoNumDoc != null && !nuevoNumDoc.isBlank()) this.numDocumento = nuevoNumDoc;
    }
    public String getNombreCompleto() { return nombreCompleto; }
    public String getNumDocumento() { return numDocumento; }
    public String getTipoDocumento() { return tipoDocumento; }
    public String getNomUsuario() { return nomUsuario; }
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
}