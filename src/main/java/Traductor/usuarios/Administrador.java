package Traductor.usuarios;

import Traductor.diccionario.Diccionario;

public class Administrador extends Docente {
    public Administrador(String nombreCompleto, String numDocumento, String tipoDocumento,
                         String nomUsuario, String contrasena) {
        super(nombreCompleto, numDocumento, tipoDocumento, nomUsuario, contrasena);
    }
    public boolean crearDocente(GestorUsuario gestor, Docente nuevoDocente) {
        if (nuevoDocente == null) return false;
        gestor.registrarUsuario(nuevoDocente);
        return true;
    }
    public boolean eliminarDocente(GestorUsuario gestor, String username) {
        return gestor.eliminarUsuario(username);
    }
    public void reiniciarDiccionario(Diccionario diccionario) {
        if (diccionario != null) diccionario.clear();
    }
}