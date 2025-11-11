package TXT;

import Traductor.usuarios.Estudiante;
import Traductor.usuarios.RegistroBusqueda;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistorialTXT {
    public static void guardarHistorial(File directorio, Estudiante estudiante) throws IOException {
        if (directorio == null || estudiante == null) return;
        if (!directorio.exists()) directorio.mkdirs();
        File file = new File(directorio, "historial_" + estudiante.getNomUsuario() + ".txt");
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            for (RegistroBusqueda r : estudiante.getHistorial()) {
                String line = String.join(";",
                        r.getFecha().toString(),
                        r.getPalabraBuscada(),
                        r.getIdioma(),
                        Boolean.toString(r.isEncontrada()),
                        r.getResultado() == null ? "" : r.getResultado()
                );
                bw.write(line);
                bw.newLine();
            }
        }
    }
    public static List<RegistroBusqueda> cargarHistorial(File directorio, String username) throws IOException {
        List<RegistroBusqueda> list = new ArrayList<>();
        if (directorio == null) return list;
        File file = new File(directorio, "historial_" + username + ".txt");
        if (!file.exists()) return list;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] p = line.split(";", -1);
                if (p.length < 5) continue;
                LocalDateTime fecha = LocalDateTime.parse(p[0].trim());
                String palabra = p[1].trim();
                String idioma = p[2].trim();
                boolean encontrada = Boolean.parseBoolean(p[3].trim());
                String resultado = p[4];
                list.add(new RegistroBusqueda(fecha, palabra, idioma, resultado, encontrada));
            }
        }
        return list;
    }
}