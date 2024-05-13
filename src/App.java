import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        BibliotecaMusical biblioteca = new BibliotecaMusical(new ArrayList<>());

        while (true) {
            String[] opciones = { "Agregar álbum", "Agregar canción a álbum", "Ver canciones de álbum",
                    "Buscar álbumes por año", "Salir" };
            JList<String> listaOpciones = new JList<>(opciones);
            JOptionPane.showMessageDialog(null, listaOpciones, "Biblioteca Musical", JOptionPane.PLAIN_MESSAGE);
            int opcionSeleccionada = listaOpciones.getSelectedIndex();

            String nombreAlbum;
            Album albumSeleccionado;

            switch (opcionSeleccionada + 1) {
                case 1:
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del álbum");
                    int anioDeLanzamiento = Integer
                            .parseInt(JOptionPane.showInputDialog("Ingrese el año de lanzamiento"));
                    String disquera = JOptionPane.showInputDialog("Ingrese la disquera");
                    String artista = JOptionPane.showInputDialog("Ingrese el artista");
                    Album album = new Album(nombre, anioDeLanzamiento, disquera, artista, new ArrayList<>());
                    biblioteca.agregarAlbum(album);
                    JOptionPane.showMessageDialog(null, "Álbum agregado exitosamente");
                    break;

                case 2:
                    nombreAlbum = JOptionPane
                            .showInputDialog("Ingrese el nombre del álbum al que desea agregar la canción");
                    albumSeleccionado = biblioteca.buscarAlbumPorNombre(nombreAlbum);
                    if (albumSeleccionado != null) {
                        String tituloCancion = JOptionPane.showInputDialog("Ingrese el título de la canción");
                        double duracionCancion = Double.parseDouble(
                                JOptionPane.showInputDialog("Ingrese la duración de la canción en minutos"));
                        Cancion cancion = new Cancion(tituloCancion, duracionCancion);
                        albumSeleccionado.agregarCancion(cancion);
                        JOptionPane.showMessageDialog(null, "Canción agregada exitosamente al álbum");
                    } else {
                        JOptionPane.showMessageDialog(null, "El álbum ingresado no existe");
                    }
                    break;

                case 3:
                    nombreAlbum = JOptionPane.showInputDialog("Ingrese el nombre del álbum que desea ver");
                    albumSeleccionado = biblioteca.buscarAlbumPorNombre(nombreAlbum);
                    if (albumSeleccionado != null) {
                        ArrayList<Cancion> canciones = albumSeleccionado.obtenerCanciones();
                        String listaCanciones = canciones.stream()
                                .map(c -> "Título: " + c.getTitulo() + ", Duración: " + c.getDuracion())
                                .collect(Collectors.joining("\n"));
                        JOptionPane.showMessageDialog(null, listaCanciones);
                    } else {
                        JOptionPane.showMessageDialog(null, "El álbum ingresado no existe");
                    }
                    break;

                case 4:
                    int anio = Integer
                            .parseInt(JOptionPane.showInputDialog("Ingrese el año de los álbumes que desea buscar"));
                    ArrayList<Album> albumesEncontrados = biblioteca.buscarAlbumesPorAnio(anio);
                    if (!albumesEncontrados.isEmpty()) {
                        String listaAlbumes = albumesEncontrados.stream()
                                .map(a -> "Nombre: " + a.getNombre() + ", Año de lanzamiento: "
                                        + a.getAnioDeLanzamiento())
                                .collect(Collectors.joining("\n"));
                        JOptionPane.showMessageDialog(null, listaAlbumes);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontraron álbumes para el año ingresado");
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }
}
