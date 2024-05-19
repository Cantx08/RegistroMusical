import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Representa una biblioteca musical que contiene una colección de álbumes.
 * 
 * @param albumes La lista de álbumes en la biblioteca.
 * 
 * @see Album
 */
public class BibliotecaMusical {
    private final List<Album> albumes;

    /**
     * Crea una nueva biblioteca musical.
     */
    public BibliotecaMusical() {
        this.albumes = new ArrayList<>();
    }

    /**
     * Busca álbumes por año de lanzamiento.
     * 
     * @param anio El año de lanzamiento a buscar.
     * @return Una lista de álbumes lanzados en el año especificado.
     */
    public List<Album> buscarAlbumesPorAnio(int anio) {
        return albumes.stream()
                .filter(album -> album.getAnioDeLanzamiento() == anio)
                .collect(Collectors.toList());
    }

    /**
     * Busca un álbum por nombre.
     * 
     * @param nombre El nombre del álbum a buscar.
     * @return El álbum con el nombre especificado, o null si no se encuentra.
     */
    public Album buscarAlbumPorNombre(String nombre) {
        return albumes.stream()
                .filter(album -> album.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    /**
     * Agrega un álbum a la biblioteca si no existe un álbum con el mismo nombre.
     * 
     * @param album El álbum a agregar.
     * @return true si el álbum fue agregado exitosamente, false si el álbum ya existe.
     */
    public boolean agregarAlbum(Album album) {
        if (albumes.stream().noneMatch(a -> a.getNombre().equalsIgnoreCase(album.getNombre()))) {
            albumes.add(album);
            return true;
        } else {
            System.out.println("El álbum " + album.getNombre() + " ya existe en la biblioteca.");
            return false;
        }
    }

    /**
     * Muestra todos los álbumes en la biblioteca.
     */
    public void mostrarAlbumes() {
        if (albumes.isEmpty()) {
            System.out.println("No hay álbumes en la biblioteca.");
        } else {
            for (Album album : albumes) {
                System.out.println(album);
                System.out.println();
            }
        }
    }
}
