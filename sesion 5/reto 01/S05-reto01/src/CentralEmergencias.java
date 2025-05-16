public class CentralEmergencias {
    public static void main(String[] args) {
        Operador operadorAmbulancia = new Operador("Laura");
        Operador operadorPatrulla = new Operador("Carlos");
        Operador operadorBomberos = new Operador("Ana");

        Ambulancia ambulancia = new Ambulancia("Ambulancia A1", operadorAmbulancia);
        Patrulla patrulla = new Patrulla("Patrulla P1", operadorPatrulla);
        UnidadBomberos bomberos = new UnidadBomberos("Bomberos B1", operadorBomberos);

        System.out.println("=== Despachando Ambulancia ===");
        ambulancia.iniciarOperacion();

        System.out.println("\n=== Despachando Patrulla ===");
        patrulla.iniciarOperacion();

        System.out.println("\n=== Despachando Unidad de Bomberos ===");
        bomberos.iniciarOperacion();
    }
}