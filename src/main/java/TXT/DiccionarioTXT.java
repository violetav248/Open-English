package TXT;

import Traductor.diccionario.Diccionario;
import Traductor.diccionario.Palabra;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class DiccionarioTXT {
    public static void guardarDiccionario(File file, Diccionario diccionario) throws IOException {
        if (file == null || diccionario == null) return;
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            for (Palabra p : diccionario.getPalabras()) {
                bw.write(p.getEspanol() + ";" + p.getIngles());
                bw.newLine();
            }
        }
    }
    public static void cargarDiccionario(File file, Diccionario diccionario) throws IOException {
        if (file == null || diccionario == null) return;
        if (!file.exists()) return;
        diccionario.clear();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] parts = line.split(";", 2);
                if (parts.length == 2) {
                    diccionario.agregarPalabra(new Palabra(parts[0].trim(), parts[1].trim()));
                }
            }
        }
    }
}