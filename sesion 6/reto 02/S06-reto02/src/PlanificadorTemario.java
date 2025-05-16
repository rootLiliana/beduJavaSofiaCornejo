import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class PlanificadorTemario {
    public static void main(String[] args) {
        // Lista concurrente de temas activos
        CopyOnWriteArrayList<Tema> temasActivos = new CopyOnWriteArrayList<>();

        // Agregar temas
        temasActivos.add(new Tema("Matemáticas", 2));
        temasActivos.add(new Tema("Lengua", 1));
        temasActivos.add(new Tema("Ciencias", 3));
        temasActivos.add(new Tema("Historia", 2));

        // Mostrar orden alfabético (por título)
        Collections.sort(temasActivos); // Usa compareTo de Tema
        System.out.println("Temas ordenados alfabéticamente:");
        for (Tema t : temasActivos) {
            System.out.println(t);
        }

        // Ordenar por prioridad ascendente
        temasActivos.sort(Comparator.comparingInt(Tema::getPrioridad));
        System.out.println("\nTemas ordenados por prioridad:");
        for (Tema t : temasActivos) {
            System.out.println(t);
        }

        // Repositorio concurrente de recursos por tema
        ConcurrentHashMap<String, String> recursosPorTema = new ConcurrentHashMap<>();
        recursosPorTema.put("Matemáticas", "https://recursos.edu/matematicas");
        recursosPorTema.put("Lengua", "https://recursos.edu/lengua");
        recursosPorTema.put("Ciencias", "https://recursos.edu/ciencias");
        recursosPorTema.put("Historia", "https://recursos.edu/historia");

        System.out.println("\nRepositorio de recursos:");
        recursosPorTema.forEach((tema, recurso) ->
                System.out.println(tema + " => " + recurso)
        );
    }
}