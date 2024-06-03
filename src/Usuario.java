import java.util.ArrayList;
import java.util.List;

/** Clase que representa un usuario con nombre, email, contraseña y una lista de álbumes */
public class Usuario {
    /** Campo que almacena el nombre del usuario */
    private String nombre;

    /** Campo que almacena el email del usuario */
    private String email;

    /** Campo que almacena la contraseña del usuario */
    private String contrasena;

    /** Campo que almacena una lista de álbumes asociados al usuario */
    private List<Album> albums;

    /**
     * Constructor que permite instanciar objetos del tipo <code>Usuario</code>.
     * @param nombre Nombre del usuario
     * @param email Email del usuario
     * @param contrasena Contraseña del usuario
     */
    public Usuario(String nombre, String email, String contrasena) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.albums = new ArrayList<>();
    }


    /**
     * Método que permite agregar un álbum a la lista de álbumes del usuario.
     * @param nombre Nombre del álbum
     * @param anoLanzamiento Año de lanzamiento del álbum
     * @param disquera Nombre de la disquera
     * @param artistas Lista de artistas que participan en el álbum
     * @return <code>true</code> si el álbum fue agregado con éxito, <code>false</code> en caso contrario
     */
    public boolean agregarAlbum(String nombre, int anoLanzamiento, String disquera, List<Artista> artistas) {
        Album album = new Album(nombre, anoLanzamiento, disquera, artistas);
        return albums.add(album);
    }

    /**
     * Método que permite buscar álbumes por año de lanzamiento.
     * @param ano Año de lanzamiento a buscar
     * @return Lista de álbumes que coinciden con el año de lanzamiento proporcionado
     */
    public List<Album> buscarAlbumPorAno(int ano) {
        List<Album> resultados = new ArrayList<>();
        for (Album album : albums) {
            if (album.getAnoLanzamiento() == ano) {
                resultados.add(album);
            }
        }
        return resultados;
    }


    /**
     * Método que permite ver la lista de canciones de un álbum.
     * @param album Álbum del cual se desea ver la lista de canciones
     * @return Lista de canciones del álbum proporcionado
     */
    public List<Cancion> verListaCanciones(Album album) {
        return album.listarCanciones();
    }

    /**
     * Método que permite obtener el email del usuario.
     * @return email del usuario
     */
    public String getEmail() {
        return email;
    }

}
