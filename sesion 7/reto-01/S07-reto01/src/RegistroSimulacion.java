import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RegistroSimulacion {

    public static void main(String[] args) {
        // Definir la ruta del directorio y archivo
        Path directorio = Paths.get("config");
        Path archivo = directorio.resolve("parametros.txt");

        // Contenido del archivo
        String parametros = """
                Tiempo de ciclo: 55.8 segundos
                Velocidad de línea: 1.2 m/s
                Número de estaciones: 8
                """;

        try {
            // Crear directorio si no existe
            if (!Files.exists(directorio)) {
                Files.createDirectory(directorio);
                System.out.println("Directorio 'config' creado.");
            }

            // Escribir parámetros en el archivo
            Files.write(archivo, parametros.getBytes());
            System.out.println("Archivo 'parametros.txt' creado y escrito correctamente.");

            // Verificar existencia del archivo
            if (Files.exists(archivo)) {
                System.out.println("Archivo verificado exitosamente.");

                // Leer y mostrar contenido
                String contenido = Files.readString(archivo);
                System.out.println("Contenido del archivo:");
                System.out.println(contenido);
            } else {
                System.out.println("El archivo no fue creado correctamente.");
            }

        } catch (IOException e) {
            System.err.println("Ocurrió un error: " + e.getMessage());
        }
    }
}