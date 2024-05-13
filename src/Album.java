import java.util.ArrayList;

public class Album {

    private String nombre;
    private int anioDeLanzamiento;
    private String disquera;
    private String artista;
    private ArrayList<Cancion> canciones;
    
    public Album(String nombre, int anioDeLanzamiento, String disquera, String artista, ArrayList<Cancion> canciones) {
        this.nombre = nombre;
        this.anioDeLanzamiento = anioDeLanzamiento;
        this.disquera = disquera;
        this.artista = artista;
        this.canciones = canciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnioDeLanzamiento() {
        return anioDeLanzamiento;
    }

    public void setAnioDeLanzamiento(int anioDeLanzamiento) {
        this.anioDeLanzamiento = anioDeLanzamiento;
    }

    public String getDisquera() {
        return disquera;
    }

    public void setDisquera(String disquera) {
        this.disquera = disquera;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

     public void agregarCancion(Cancion cancion) {
        if (canciones.stream().noneMatch(c -> c.getTitulo().equals(cancion.getTitulo()))) {
            canciones.add(cancion);
        }
    }

    public ArrayList<Cancion> obtenerCanciones() {
        return canciones;
    }
    
}