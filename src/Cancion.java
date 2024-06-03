/** Clase que representa una canción con título y duración */
public class Cancion {

    /** Campo que almacena el título de la canción */
    private String titulo;

    /** Campo que almacena la duración de la canción */
    private float duracion;

    /**
     * Constructor que permite instanciar objetos del tipo <code>Cancion</code>.
     * @param titulo Título de la canción
     * @param duracion Duración de la canción
     */
    public Cancion(String titulo, float duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    /**
     * Método que devuelve el título de la canción.
     * @return Título de la canción
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Método que devuelve la duración de la canción.
     * @return Duración de la canción
     */
    public float getDuracion() {
        return duracion;
    }

}
