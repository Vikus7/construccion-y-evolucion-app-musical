import java.util.ArrayList;
import java.util.List;

/** Clase que representa un álbum musical con nombre, año de lanzamiento, disquera, artistas y canciones */
public class Album {

    /** Campo que almacena el nombre del álbum */
    private String nombre;

    /** Campo que almacena el año de lanzamiento del álbum */
    private int anoLanzamiento;

    /** Campo que almacena el nombre de la disquera */
    private String disquera;

    /** Campo que almacena una lista de artistas que participan en el álbum */
    private List<Artista> artistas;

    /** Campo que almacena una lista de canciones del álbum */
    private List<Cancion> canciones;

    /**
     * Constructor que permite instanciar objetos del tipo <code>Album</code>.
     * @param nombre Nombre del álbum
     * @param anoLanzamiento Año de lanzamiento del álbum
     * @param disquera Nombre de la disquera
     * @param artistas Lista de artistas que participan en el álbum
     */
    public Album(String nombre, int anoLanzamiento, String disquera, List<Artista> artistas) {
        this.nombre = nombre;
        this.anoLanzamiento = anoLanzamiento;
        this.disquera = disquera;
        this.artistas = artistas;
        this.canciones = new ArrayList<>();
    }

    /**
     * Método que permite agregar una canción al álbum.
     * @param titulo Título de la canción
     * @param duracion Duración de la canción
     * @return <code>true</code> si la canción fue agregada con éxito, <code>false</code> si la canción ya existe en el álbum
     */
    public boolean agregarCancion(String titulo, float duracion) {
        if (existeCancion(titulo)) {
            return false;
        }
        Cancion cancion = new Cancion(titulo, duracion);
        return canciones.add(cancion);
    }

    /**
     * Método que devuelve la lista de canciones del álbum.
     * @return Lista de canciones del álbum
     */
    public List<Cancion> listarCanciones() {
        return canciones;
    }

    /**
     * Método que verifica si una canción existe en el álbum.
     * @param titulo Título de la canción a verificar
     * @return <code>true</code> si la canción existe en el álbum, <code>false</code> en caso contrario
     */
    public boolean existeCancion(String titulo) {
        for (Cancion cancion : canciones) {
            if (cancion.getTitulo().equals(titulo)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que devuelve el año de lanzamiento del álbum.
     * @return Año de lanzamiento del álbum
     */
    public int getAnoLanzamiento() {
        return anoLanzamiento;
    }

    /**
     * Método que devuelve el nombre del álbum.
     * @return Nombre del álbum
     */
    public String getNombre() {
        return nombre;
    }
}
