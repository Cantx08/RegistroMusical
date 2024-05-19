public class Cancion {
    private final String titulo;
    private final double duracion;

    public Cancion(String titulo, double duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Duración: " + duracion + " minutos";
    }
}