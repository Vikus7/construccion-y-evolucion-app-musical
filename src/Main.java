import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);

        // Registrar usuario
        System.out.println("Ingrese su nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese su email:");
        String email = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contrasena = scanner.nextLine();
        sistema.registrarUsuario(nombre, email, contrasena);

        // Buscar el usuario registrado
        Usuario usuario = sistema.buscarUsuarioPorEmail(email);

        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        boolean salir = false;
        while (!salir) {
            System.out.println("Menú:");
            System.out.println("1. Agregar nuevo álbum");
            System.out.println("2. Agregar canción a un álbum existente");
            System.out.println("3. Ver lista de canciones de un álbum");
            System.out.println("4. Buscar álbumes por año");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del álbum:");
                    String nombreAlbum = scanner.nextLine();
                    System.out.println("Ingrese el año de lanzamiento:");
                    int anoLanzamiento = scanner.nextInt();
                    scanner.nextLine(); // consumir el salto de línea
                    System.out.println("Ingrese la disquera:");
                    String disquera = scanner.nextLine();
                    System.out.println("Ingrese los nombres de los artistas (separados por comas):");
                    String nombresArtistas = scanner.nextLine();
                    List<Artista> artistas = Arrays.asList(nombresArtistas.split(",")).stream()
                            .map(nombreArtista -> new Artista(nombreArtista.trim(), ""))
                            .toList();
                    usuario.agregarAlbum(nombreAlbum, anoLanzamiento, disquera, artistas);
                    System.out.println("Álbum agregado con éxito.");
                    break;

                case 2:
                    System.out.println("Ingrese el año del álbum al que quiere agregar la canción:");
                    int anoAlbum = scanner.nextInt();
                    scanner.nextLine(); // consumir el salto de línea
                    List<Album> albums = usuario.buscarAlbumPorAno(anoAlbum);
                    if (albums.isEmpty()) {
                        System.out.println("No se encontraron álbumes para el año especificado.");
                    } else {
                        Album album = albums.get(0); // asumiendo que hay un solo álbum por año
                        System.out.println("Ingrese el título de la canción:");
                        String tituloCancion = scanner.nextLine();
                        System.out.println("Ingrese la duración de la canción (en minutos):");
                        float duracionCancion = scanner.nextFloat();
                        scanner.nextLine(); // consumir el salto de línea
                        if (album.agregarCancion(tituloCancion, duracionCancion)) {
                            System.out.println("Canción agregada con éxito.");
                        } else {
                            System.out.println("Error: Ya existe una canción con ese título en el álbum.");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Ingrese el año del álbum cuya lista de canciones quiere ver:");
                    int anoAlbumLista = scanner.nextInt();
                    scanner.nextLine(); // consumir el salto de línea
                    List<Album> albumsLista = usuario.buscarAlbumPorAno(anoAlbumLista);
                    if (albumsLista.isEmpty()) {
                        System.out.println("No se encontraron álbumes para el año especificado.");
                    } else {
                        Album albumLista = albumsLista.get(0); // asumiendo que hay un solo álbum por año
                        List<Cancion> canciones = usuario.verListaCanciones(albumLista);
                        System.out.println("Lista de canciones del álbum " + albumLista.getNombre() + ":");
                        for (Cancion cancion : canciones) {
                            System.out.println(cancion.getTitulo() + " - " + cancion.getDuracion() + " min");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Ingrese el año de los álbumes que quiere buscar:");
                    int anoBuscar = scanner.nextInt();
                    scanner.nextLine(); // consumir el salto de línea
                    List<Album> albumsBuscar = sistema.buscarAlbumPorAno(anoBuscar);
                    System.out.println("Álbumes del año " + anoBuscar + ":");
                    for (Album album : albumsBuscar) {
                        System.out.println(album.getAnoLanzamiento() + ": " + album.getNombre());
                    }
                    break;

                case 5:
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}
