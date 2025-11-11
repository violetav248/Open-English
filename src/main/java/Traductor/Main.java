package Traductor;

import GUI.MainFrame;
import Traductor.diccionario.Diccionario;
import Traductor.usuarios.Administrador;
import Traductor.usuarios.Estudiante;
import Traductor.usuarios.GestorUsuario;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Diccionario diccionario = new Diccionario();
        GestorUsuario gestor = new GestorUsuario();
        Administrador admin = new Administrador("Admin Uno","123","CC","admin1","pass");
        gestor.registrarUsuario(admin);
        admin.agregarPalabra(diccionario,"hola","hello");
        admin.agregarPalabra(diccionario,"adios","goodbye");
        Estudiante est = new Estudiante("Juan Perez","456","CC","juan","1234");
        gestor.registrarUsuario(est);
        SwingUtilities.invokeLater(() -> new MainFrame(diccionario, est).setVisible(true));
    }
}