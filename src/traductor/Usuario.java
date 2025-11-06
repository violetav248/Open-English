/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package traductor;

/**
 *
 * @author Manuel Alejandro
 */
public abstract class Usuario {
    private String nombreCompleto, numDocumento,nomUsuario, conbbtraseña,tipoUsuario;

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getConbbtraseña() {
        return conbbtraseña;
    }

    public void setConbbtraseña(String conbbtraseña) {
        this.conbbtraseña = conbbtraseña;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    
    public boolean verificarContraseña(int password){
        return false;
    }
    
    public void actualizarDatos(){
        
    }
    
}
