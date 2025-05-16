import java.io.*;

public class AnalizadorDeLogs {

    public static void main(String[] args) {
        // Paso 1: Generar archivo errores.log de prueba (puedes omitir esto si ya tienes uno)
        crearArchivoDePrueba();

        // Paso 2: Analizar el archivo
        String archivoLog = "errores.log";
        int totalLineas = 0;
        int cantidadErrores = 0;
        int cantidadAdvertencias = 0;

        try (BufferedReader lector = new BufferedReader(new FileReader(archivoLog))) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                totalLineas++;

                if (linea.contains("ERROR")) {
                    cantidadErrores++;
                }

                if (linea.contains("WARNING")) {
                    cantidadAdvertencias++;
                }
            }

            System.out.println("Resumen del análisis:");
            System.out.println("Total de líneas leídas: " + totalLineas);
            System.out.println("Cantidad de errores: " + cantidadErrores);
            System.out.println("Cantidad de advertencias: " + cantidadAdvertencias);

            int totalErroresYAdvertencias = cantidadErrores + cantidadAdvertencias;
            double porcentaje = totalLineas > 0
                    ? (totalErroresYAdvertencias * 100.0) / totalLineas
                    : 0.0;

            System.out.printf("Porcentaje de líneas con errores y advertencias: %.2f%%\n", porcentaje);

        } catch (IOException e) {
            System.err.println("Ocurrió un problema al leer el archivo: " + e.getMessage());

            try (BufferedWriter escritor = new BufferedWriter(new FileWriter("registro_fallos.txt", true))) {
                escritor.write("Error al procesar archivo: " + e.getMessage());
                escritor.newLine();
            } catch (IOException ex) {
                System.err.println("No se pudo escribir en registro_fallos.txt: " + ex.getMessage());
            }
        }
    }

    // Método para crear un archivo de prueba con contenido simulado
    private static void crearArchivoDePrueba() {
        String[] lineas = {
                "INFO: Inicio del sistema",
                "WARNING: Memoria baja",
                "ERROR: Fallo al conectar a la base de datos",
                "INFO: Usuario autenticado",
                "ERROR: Timeout en la solicitud",
                "WARNING: Uso elevado de CPU",
                "INFO: Proceso completado"
        };

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("errores.log"))) {
            for (String linea : lineas) {
                escritor.write(linea);
                escritor.newLine();
            }
        } catch (IOException e) {
            System.err.println("No se pudo crear el archivo de prueba: " + e.getMessage());
        }
    }
}