# Biblioteca Musical

Este proyecto es una aplicación de consola en Java que permite a los usuarios administrar una biblioteca de álbumes musicales. Proporciona funcionalidades para agregar álbumes, agregar canciones a los álbumes, evitar duplicados de canciones, ver detalles de los álbumes y buscar álbumes por año de lanzamiento.

## Requisitos

- Java 8 o superior

## Estructura del proyecto


biblioteca-musical/
├── src/
│   ├── Album.java
│   ├── BibliotecaMusical.java
│   ├── Cancion.java
│   └── Main.java


## Clases

### `Album`

Esta clase representa un álbum musical y contiene los siguientes atributos:

- `nombre`: El nombre del álbum.
- `anioDeLanzamiento`: El año de lanzamiento del álbum.
- `disquera`: La disquera que lanzó el álbum.
- `artista`: El artista del álbum.
- `canciones`: Una lista de canciones pertenecientes al álbum.

### `Cancion`

Esta clase representa una canción y contiene los siguientes atributos:

- `titulo`: El título de la canción.
- `duracion`: La duración de la canción en minutos.

### `BibliotecaMusical`

Esta clase representa la biblioteca musical y proporciona las siguientes funcionalidades:

- `buscarAlbumesPorAnio`: Busca y devuelve una lista de álbumes lanzados en un año específico.
- `buscarAlbumPorNombre`: Busca y devuelve un álbum por su nombre.
- `agregarAlbum`: Agrega un nuevo álbum a la biblioteca.
- `mostrarAlbumes`: Muestra una lista de todos los álbumes en la biblioteca.

## Uso

1. Compilar las clases Java.
2. Ejecutar la clase `Main`.
3. Seguir las instrucciones en la consola para interactuar con la biblioteca musical.

## Historias de usuario

1. **HU1**: Como usuario, quiero poder agregar un nuevo álbum con su información básica (nombre, año de lanzamiento, disquera y artistas) para mantener un registro de la música que escucho.
2. **HU2**: Como usuario, quiero poder agregar canciones a un álbum existente, proporcionando el título de la canción y su duración en minutos, para mantener un registro completo de todas las canciones en un álbum.
3. **HU3**: Como usuario, quiero que el sistema evite que agregue canciones con títulos repetidos a un álbum, para mantener la integridad de la información.
4. **HU4**: Como usuario, quiero poder ver la lista de canciones de un álbum específico, junto con su duración, para conocer la composición del álbum.
5. **HU5**: Como usuario, quiero poder buscar álbumes por el año para encontrar rápidamente la información que estoy buscando.

## Contribución

Si deseas contribuir a este proyecto, puedes hacer un fork del repositorio, crear una rama con tus cambios y enviar un pull request.
