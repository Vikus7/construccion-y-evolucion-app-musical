/** Clase que representa un artista con nombre y apellido */
public class Artista {

    /** Campo que almacena el nombre del artista */
    private String nombre;

    /** Campo que almacena el apellido del artista */
    private String apellido;

    /**
     * Constructor que permite instanciar objetos del tipo <code>Artista</code>.
     * @param nombre Nombre del artista
     * @param apellido Apellido del artista
     */
    public Artista(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    /**
     * Método que devuelve el nombre del artista.
     * @return Nombre del artista
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que devuelve el apellido del artista.
     * @return Apellido del artista
     */
    public String getApellido() {
        return apellido;
    }
}
