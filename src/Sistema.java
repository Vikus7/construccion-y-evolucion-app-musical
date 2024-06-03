import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Usuario> usuarios;

    public Sistema() {
        usuarios = new ArrayList<>();
    }

    public boolean registrarUsuario(String nombre, String email, String contrasena) {
        Usuario usuario = new Usuario(nombre, email, contrasena);
        return usuarios.add(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    public List<Album> buscarAlbumPorAno(int ano) {
        List<Album> resultados = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            resultados.addAll(usuario.buscarAlbumPorAno(ano));
        }
        return resultados;
    }

}
