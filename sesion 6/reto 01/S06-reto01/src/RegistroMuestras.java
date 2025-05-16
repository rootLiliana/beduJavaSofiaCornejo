import java.util.*;

public class RegistroMuestras {

    public static void main(String[] args) {

        // Paso 1: ArrayList para registrar todas las especies en orden
        ArrayList<String> muestrasEnOrden = new ArrayList<>();
        muestrasEnOrden.add("Homo sapiens");
        muestrasEnOrden.add("Mus musculus");
        muestrasEnOrden.add("Arabidopsis thaliana");
        muestrasEnOrden.add("Homo sapiens"); // repetida

        // Paso 2: HashSet para filtrar especies únicas
        HashSet<String> especiesUnicas = new HashSet<>(muestrasEnOrden);

        // Paso 3: HashMap para asociar ID de muestra con investigador
        HashMap<String, String> idInvestigador = new HashMap<>();
        idInvestigador.put("M-001", "Dra. López");
        idInvestigador.put("M-002", "Dr. Hernández");
        idInvestigador.put("M-003", "Lic. Ramírez");
        idInvestigador.put("M-004", "Dra. López");

        // Paso 4: Mostrar resultados

        // Mostrar todas las especies registradas (orden de llegada)
        System.out.println("Orden de llegada de las muestras:");
        for (String especie : muestrasEnOrden) {
            System.out.println("- " + especie);
        }

        // Mostrar especies únicas
        System.out.println("\nEspecies únicas procesadas:");
        for (String especie : especiesUnicas) {
            System.out.println("- " + especie);
        }

        // Mostrar relación ID de muestra → investigador
        System.out.println("\nRelación ID de muestra → Investigador:");
        for (Map.Entry<String, String> entrada : idInvestigador.entrySet()) {
            System.out.println("- " + entrada.getKey() + " → " + entrada.getValue());
        }

        // Búsqueda por ID de muestra
        String idBusqueda = "M-002";
        System.out.println("\nBúsqueda del investigador responsable de la muestra " + idBusqueda + ":");
        if (idInvestigador.containsKey(idBusqueda)) {
            System.out.println("→ " + idInvestigador.get(idBusqueda));
        } else {
            System.out.println("→ No se encontró el ID de muestra.");
        }
    }
}