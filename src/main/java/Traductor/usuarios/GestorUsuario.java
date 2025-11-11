package Traductor.usuarios;

import java.util.ArrayList;
import java.util.List;

public class GestorUsuario {
    private final List<Usuario> listaUsuarios = new ArrayList<>();
    public void registrarUsuario(Usuario usuario) {
        if (usuario == null) return;
        boolean duplicado = listaUsuarios.stream()
                .anyMatch(u -> u.getNomUsuario().equalsIgnoreCase(usuario.getNomUsuario()));
        if (!duplicado) {
            listaUsuarios.add(usuario);
        }
    }
    public boolean eliminarUsuario(String username) {
        return listaUsuarios.removeIf(u -> u.getNomUsuario().equalsIgnoreCase(username));
    }
    public boolean actualizarUsuario(String username, String nuevaContrasena) {
        for (Usuario u : listaUsuarios) {
            if (u.getNomUsuario().equalsIgnoreCase(username)) {
                u.setContrasena(nuevaContrasena);
                return true;
            }
        }
        return false;
    }
    public List<Usuario> getUsuarios() { return List.copyOf(listaUsuarios); }
}