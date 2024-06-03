import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String email;
    private String contrasena;
    private List<Album> albums;

    public Usuario(String nombre, String email, String contrasena) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.albums = new ArrayList<>();
    }

    public boolean agregarAlbum(String nombre, int anoLanzamiento, String disquera, List<Artista> artistas) {
        Album album = new Album(nombre, anoLanzamiento, disquera, artistas);
        return albums.add(album);
    }

    public List<Album> buscarAlbumPorAno(int ano) {
        List<Album> resultados = new ArrayList<>();
        for (Album album : albums) {
            if (album.getAnoLanzamiento() == ano) {
                resultados.add(album);
            }
        }
        return resultados;
    }

    public List<Cancion> verListaCanciones(Album album) {
        return album.listarCanciones();
    }

    public String getEmail() {
        return email;
    }

}
