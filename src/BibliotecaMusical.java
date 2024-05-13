import java.util.ArrayList;
import java.util.stream.Collectors;

public class BibliotecaMusical {
    private ArrayList<Album> albumes;

    public BibliotecaMusical(ArrayList<Album> albumes) {
        this.albumes = albumes;
    }

    public ArrayList<Album> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(ArrayList<Album> albumes) {
        this.albumes = albumes;
    }

    public ArrayList<Album> buscarAlbumesPorAnio(int anio) {
        return albumes.stream()
                .filter(a -> a.getAnioDeLanzamiento() == anio)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Album buscarAlbumPorNombre(String nombre) {
        return albumes.stream()
                .filter(a -> a.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    public void agregarAlbum(Album album) {
        albumes.add(album);
    }
}
