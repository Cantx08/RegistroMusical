import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BibliotecaMusical {
    private final List<Album> albumes;

    public BibliotecaMusical() {
        this.albumes = new ArrayList<>();
    }

    public List<Album> buscarAlbumesPorAnio(int anio) {
        return albumes.stream()
                .filter(album -> album.getAnioDeLanzamiento() == anio)
                .collect(Collectors.toList());
    }

    public Album buscarAlbumPorNombre(String nombre) {
        return albumes.stream()
                .filter(album -> album.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public boolean agregarAlbum(Album album) {
        if (albumes.stream().noneMatch(a -> a.getNombre().equalsIgnoreCase(album.getNombre()))) {
            albumes.add(album);
            return true;
        } else {
            System.out.println("El álbum " + album.getNombre() + " ya existe en la biblioteca.");
            return false;
        }
    }

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