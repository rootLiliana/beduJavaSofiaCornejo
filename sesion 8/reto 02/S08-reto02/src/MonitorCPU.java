import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MonitorCPU {

    // Excepción personalizada
    static class ConsumoCriticoException extends Exception {
        public ConsumoCriticoException(String mensaje) {
            super(mensaje);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = null;
        Set<Double> consumosCPU = new HashSet<>();

        try {
            scanner = new Scanner(System.in);
            System.out.println("Ingresa el consumo de CPU de los servidores (en %, escribe 'fin' para terminar):");

            while (true) {
                System.out.print("Consumo CPU: ");
                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("fin")) {
                    break;
                }

                double consumo;

                // Validar que sea número
                try {
                    consumo = Double.parseDouble(input);
                } catch (NumberFormatException e) {
                    System.out.println("Error: El valor debe ser numérico.");
                    continue;
                }

                // Validar rango
                if (consumo < 0 || consumo > 100) {
                    System.out.println("Error: El valor debe estar entre 0 y 100.");
                    continue;
                }

                // Validar duplicados
                if (consumosCPU.contains(consumo)) {
                    System.out.println("Error: No se permiten consumos duplicados.");
                    continue;
                }

                // Validar consumo crítico
                if (consumo > 95) {
                    throw new ConsumoCriticoException("¡Alerta! Consumo crítico detectado: " + consumo + "%");
                }

                consumosCPU.add(consumo);
                System.out.println("Consumo registrado correctamente.");
            }

            System.out.println("\nConsumos registrados:");
            for (Double c : consumosCPU) {
                System.out.println("- " + c + "%");
            }

        } catch (ConsumoCriticoException e) {
            System.out.println(e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            System.out.println("Monitoreo finalizado.");
        }
    }
}