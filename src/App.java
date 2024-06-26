import javax.swing.*;
import java.util.Optional;

/**
 * Clase principal que contiene el menú de la Biblioteca Musical.
 */
public class App {
    private static final BibliotecaMusical bibliotecaMusical = new BibliotecaMusical();

    /**
     * Método principal que inicia la aplicación mostrando el menú principal.
     *
     * @param args Los argumentos de línea de comando (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {
        mostrarMenuPrincipal();
    }

    /**
     * Muestra el menú principal de la aplicación y maneja las opciones seleccionadas por el usuario.
     */
    private static void mostrarMenuPrincipal() {
        String[] opciones = {"Agregar álbum", "Agregar canción a álbum", "Ver canciones de álbum", "Buscar álbumes por año", "Salir"};
        int opcionSeleccionada = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Biblioteca Musical", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

        switch (opcionSeleccionada) {
            case 0:
                agregarAlbum();
                break;
            case 1:
                agregarCancionAlbum();
                break;
            case 2:
                verCancionesAlbum();
                break;
            case 3:
                buscarAlbumesPorAnio();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida", "Error", JOptionPane.ERROR_MESSAGE);
        }

        mostrarMenuPrincipal();
    }

    /**
     * Solicita al usuario los datos para agregar un nuevo álbum a la biblioteca musical.
     */
    private static void agregarAlbum() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del álbum");
        int anioDeLanzamiento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de lanzamiento"));
        String disquera = JOptionPane.showInputDialog("Ingrese la disquera");
        String artista = JOptionPane.showInputDialog("Ingrese el artista");

        Album album = new Album(nombre, anioDeLanzamiento, disquera, artista);
        bibliotecaMusical.agregarAlbum(album);
        JOptionPane.showMessageDialog(null, "Álbum agregado exitosamente");
    }

    /**
     * Solicita al usuario los datos para agregar una nueva canción a un álbum existente.
     */
    private static void agregarCancionAlbum() {
        String nombreAlbum = JOptionPane.showInputDialog("Ingrese el nombre del álbum al que desea agregar la canción");
        Album albumSeleccionado = bibliotecaMusical.buscarAlbumPorNombre(nombreAlbum);

        if (albumSeleccionado != null) {
            String tituloCancion = JOptionPane.showInputDialog("Ingrese el título de la canción");
            double duracionCancion = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la duración de la canción en minutos"));
            Cancion cancion = new Cancion(tituloCancion, duracionCancion);
            albumSeleccionado.agregarCancion(cancion);
            JOptionPane.showMessageDialog(null, "Canción agregada exitosamente al álbum");
        } else {
            JOptionPane.showMessageDialog(null, "El álbum ingresado no existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Solicita al usuario el nombre de un álbum y muestra las canciones que contiene.
     */
    private static void verCancionesAlbum() {
        String nombreAlbum = JOptionPane.showInputDialog("Ingrese el nombre del álbum que desea ver");
        Album albumSeleccionado = bibliotecaMusical.buscarAlbumPorNombre(nombreAlbum);

        if (albumSeleccionado != null) {
            StringBuilder listaCanciones = new StringBuilder();
            for (Cancion cancion : albumSeleccionado.getCanciones()) {
                listaCanciones.append("Título: ").append(cancion.getTitulo()).append(", Duración: ").append(cancion.getDuracion()).append(" minutos\n");
            }
            JOptionPane.showMessageDialog(null, listaCanciones.toString(), "Canciones del álbum", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "El álbum ingresado no existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Solicita al usuario un año y muestra los álbumes lanzados en ese año.
     */
    private static void buscarAlbumesPorAnio() {
        String anioCadena = JOptionPane.showInputDialog("Ingrese el año de los álbumes que desea buscar");
        int anio = Optional.ofNullable(anioCadena)
                .map(Integer::parseInt)
                .orElse(0);

        if (anio != 0) {
            StringBuilder listaAlbumes = new StringBuilder();
            for (Album album : bibliotecaMusical.buscarAlbumesPorAnio(anio)) {
                listaAlbumes.append("Nombre: ").append(album.getNombre()).append(", Año de lanzamiento: ").append(album.getAnioDeLanzamiento()).append("\n");
            }
            JOptionPane.showMessageDialog(null, listaAlbumes.toString(), "Álbumes del año " + anio, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "El año ingresado no es válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}