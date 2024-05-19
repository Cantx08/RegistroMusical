import java.util.ArrayList;
import java.util.List;

public class Album {
    private final String nombre;
    private final int anioDeLanzamiento;
    private final String disquera;
    private final String artista;
    private final List<Cancion> canciones;

    public Album(String nombre, int anioDeLanzamiento, String disquera, String artista) {
        this.nombre = nombre;
        this.anioDeLanzamiento = anioDeLanzamiento;
        this.disquera = disquera;
        this.artista = artista;
        this.canciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnioDeLanzamiento() {
        return anioDeLanzamiento;
    }

    public String getDisquera() {
        return disquera;
    }

    public String getArtista() {
        return artista;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public boolean agregarCancion(Cancion cancion) {
        if (canciones.stream().noneMatch(c -> c.getTitulo().equalsIgnoreCase(cancion.getTitulo()))) {
            canciones.add(cancion);
            return true;
        } else {
            System.out.println("La canción " + cancion.getTitulo() + " ya existe en el álbum.");
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Año de lanzamiento: ").append(anioDeLanzamiento).append("\n");
        sb.append("Disquera: ").append(disquera).append("\n");
        sb.append("Artista: ").append(artista).append("\n");
        sb.append("Canciones:\n");
        for (Cancion cancion : canciones) {
            sb.append("\t").append(cancion.toString()).append("\n");
        }
        return sb.toString();
    }
}