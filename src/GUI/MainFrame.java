/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import traductor.Estudiante;

public class MainFrame extends JFrame {
    private final Diccionario diccionario;
    private final Estudiante estudiante;
    private JTextField txtPalabra;
    private JComboBox<String> cmbIdioma;
    private JTextArea txtResultado;
    public MainFrame(Diccionario diccionario, Estudiante estudiante) {
        super("Traductor");
        this.diccionario = diccionario;
        this.estudiante = estudiante;
        initUI();
    }
    private void initUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 360);
        setLocationRelativeTo(null);
        JPanel content = new JPanel(new BorderLayout(8, 8));
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtPalabra = new JTextField(20);
        cmbIdioma = new JComboBox<>(new String[]{"ES", "EN"});
        JButton btnTraducir = new JButton("Traducir");
        top.add(new JLabel("Palabra:"));
        top.add(txtPalabra);
        top.add(new JLabel("Idioma origen:"));
        top.add(cmbIdioma);
        top.add(btnTraducir);
        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtResultado);
        content.add(top, BorderLayout.NORTH);
        content.add(scroll, BorderLayout.CENTER);
        btnTraducir.addActionListener(e -> traducir());
        setContentPane(content);
    }
    private void traducir() {
        String palabra = txtPalabra.getText().trim();
        String idioma = Objects.requireNonNull(cmbIdioma.getSelectedItem()).toString();
        if (palabra.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese una palabra", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String res = estudiante.buscarPalabra(diccionario, palabra, idioma);
        if (res == null) {
            txtResultado.append("No encontrada: " + palabra + " (" + idioma + ")\n");
        } else {
            txtResultado.append(palabra + " (" + idioma + ") -> " + res + "\n");
        }
    }
}