public class Cancion {
    private String titulo;
    private float duracion;

    public Cancion(String titulo, float duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public float getDuracion() {
        return duracion;
    }

}
