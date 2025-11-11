package TXT;

import Traductor.usuarios.Estudiante;
import Traductor.usuarios.Usuario;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class UsuariosTXT {
    public static void guardarUsuarios(File file, List<Usuario> usuarios) throws IOException {
        if (file == null || usuarios == null) return;
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            for (Usuario u : usuarios) {
                bw.write(String.join(";",
                        safe(u.getNombreCompleto()),
                        safe(u.getTipoDocumento()),
                        safe(u.getNumDocumento()),
                        safe(u.getNomUsuario()),
                        safe(u.getContrasena())
                ));
                bw.newLine();
            }
        }
    }
    public static List<Usuario> cargarUsuarios(File file) throws IOException {
        List<Usuario> result = new ArrayList<>();
        if (file == null || !file.exists()) return result;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] p = line.split(";", -1);
                if (p.length < 5) continue;
                String nombre = p[0].trim();
                String tipoDoc = p[1].trim();
                String numDoc = p[2].trim();
                String username = p[3].trim();
                String contrasena = p[4].trim();
                result.add(new Estudiante(nombre, numDoc, tipoDoc, username, contrasena));
            }
        }
        return result;
    }
    private static String safe(String s) { return s == null ? "" : s; }
}