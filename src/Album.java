import java.util.ArrayList;
import java.util.List;

public class Album {
    private String nombre;
    private int anoLanzamiento;
    private String disquera;
    private List<Artista> artistas;
    private List<Cancion> canciones;

    public Album(String nombre, int anoLanzamiento, String disquera, List<Artista> artistas) {
        this.nombre = nombre;
        this.anoLanzamiento = anoLanzamiento;
        this.disquera = disquera;
        this.artistas = artistas;
        this.canciones = new ArrayList<>();
    }

    public boolean agregarCancion(String titulo, float duracion) {
        if (existeCancion(titulo)) {
            return false;
        }
        Cancion cancion = new Cancion(titulo, duracion);
        return canciones.add(cancion);
    }

    public List<Cancion> listarCanciones() {
        return canciones;
    }

    public boolean existeCancion(String titulo) {
        for (Cancion cancion : canciones) {
            if (cancion.getTitulo().equals(titulo)) {
                return true;
            }
        }
        return false;
    }

    public int getAnoLanzamiento() {
        return anoLanzamiento;
    }

    public String getNombre() {
        return nombre;
    }
}
