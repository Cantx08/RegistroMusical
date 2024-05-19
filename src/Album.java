import java.util.ArrayList;
import java.util.List;

/**
 * Representa un álbum musical.
 * Contiene información sobre el nombre, año de lanzamiento, disquera, artista y canciones del álbum.
 * 
 * @param nombre El nombre del álbum.
 * @param anioDeLanzamiento El año en que se lanzó el álbum.
 * @param disquera La disquera que lanzó el álbum.
 * @param artista El artista que creó el álbum.
 * @param canciones La lista de canciones del álbum.
 * 
 * @see Cancion
 */
public class Album {
    private final String nombre;
    private final int anioDeLanzamiento;
    private final String disquera;
    private final String artista;
    private final List<Cancion> canciones;

    /**
     * Crea un nuevo álbum con la información especificada.
     * 
     * @param nombre El nombre del álbum.
     * @param anioDeLanzamiento El año de lanzamiento del álbum.
     * @param disquera La disquera que lanzó el álbum.
     * @param artista El artista que creó el álbum.
     */
    public Album(String nombre, int anioDeLanzamiento, String disquera, String artista) {
        this.nombre = nombre;
        this.anioDeLanzamiento = anioDeLanzamiento;
        this.disquera = disquera;
        this.artista = artista;
        this.canciones = new ArrayList<>();
    }

    /**
     * Obtiene el nombre del álbum.
     * 
     * @return El nombre del álbum.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el año de lanzamiento del álbum.
     * 
     * @return El año de lanzamiento del álbum.
     */
    public int getAnioDeLanzamiento() {
        return anioDeLanzamiento;
    }

    /**
     * Obtiene la disquera del álbum.
     * 
     * @return La disquera del álbum.
     */
    public String getDisquera() {
        return disquera;
    }

    /**
     * Obtiene el artista del álbum.
     * 
     * @return El artista del álbum.
     */
    public String getArtista() {
        return artista;
    }

    /**
     * Obtiene la lista de canciones del álbum.
     * 
     * @return La lista de canciones del álbum.
     */
    public List<Cancion> getCanciones() {
        return canciones;
    }

    /**
     * Agrega una canción al álbum si no existe una canción con el mismo título en el álbum.
     * 
     * @param cancion La canción a agregar.
     * @return true si la canción fue agregada exitosamente, false si la canción ya existe.
     */
    public boolean agregarCancion(Cancion cancion) {
        if (canciones.stream().noneMatch(c -> c.getTitulo().equalsIgnoreCase(cancion.getTitulo()))) {
            canciones.add(cancion);
            return true;
        } else {
            System.out.println("La canción " + cancion.getTitulo() + " ya existe en el álbum.");
            return false;
        }
    }

    /**
     * Devuelve una representación en cadena de texto del álbum.
     * 
     * @return Una cadena de texto que representa el álbum.
     */
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
