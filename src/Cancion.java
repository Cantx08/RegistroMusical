/**
 * Representa una canción.
 * 
 * @param titulo El título de la canción.
 * @param duracion La duración de la canción en minutos.
 */
public class Cancion {
    private final String titulo;
    private final double duracion;

    /**
     * Crea una nueva canción con el título y la duración especificados.
     * 
     * @param titulo El título de la canción.
     * @param duracion La duración de la canción en minutos.
     */
    public Cancion(String titulo, double duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    /**
     * Obtiene el título de la canción.
     * 
     * @return El título de la canción.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene la duración de la canción.
     * 
     * @return La duración de la canción en minutos.
     */
    public double getDuracion() {
        return duracion;
    }

    /**
     * Devuelve una representación en cadena de texto de la canción.
     * 
     * @return Una cadena de texto que representa la canción.
     */
    @Override
    public String toString() {
        return "Título: " + titulo + ", Duración: " + duracion + " minutos";
    }
}
