import java.util.ArrayList;
import java.util.List;

/** Clase que representa un sistema de gestión de usuarios y álbumes */
public class Sistema {

    /** Campo que almacena la lista de usuarios del sistema */
    private List<Usuario> usuarios;

    /**
     * Constructor que permite instanciar objetos del tipo <code>Sistema</code>.
     */
    public Sistema() {
        usuarios = new ArrayList<>();
    }


    /**
     * Método que permite registrar un nuevo usuario en el sistema.
     * @param nombre Nombre del usuario
     * @param email Email del usuario
     * @param contrasena Contraseña del usuario
     * @return <code>true</code> si el usuario fue registrado con éxito, <code>false</code> en caso contrario
     */
    public boolean registrarUsuario(String nombre, String email, String contrasena) {
        Usuario usuario = new Usuario(nombre, email, contrasena);
        return usuarios.add(usuario);
    }

    /**
     * Método que permite buscar un usuario por su email.
     * @param email Email del usuario a buscar
     * @return El usuario con el email especificado, o <code>null</code> si no se encuentra
     */
    public Usuario buscarUsuarioPorEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    /**
     * Método que permite buscar álbumes por año de lanzamiento en todos los usuarios del sistema.
     * @param ano Año de lanzamiento a buscar
     * @return Lista de álbumes que coinciden con el año de lanzamiento proporcionado
     */
    public List<Album> buscarAlbumPorAno(int ano) {
        List<Album> resultados = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            resultados.addAll(usuario.buscarAlbumPorAno(ano));
        }
        return resultados;
    }

}
