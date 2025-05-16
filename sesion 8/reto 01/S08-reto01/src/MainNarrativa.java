import java.util.Scanner;

public class MainNarrativa {

    public interface TransicionHistoria {
        void siguienteEscena();
    }

    public interface GestorDialogo {
        void mostrarDialogo(String dialogo);
    }

    public interface LogicaDecision {
        boolean tomarDecision();
    }

    public static class TransicionSimple implements TransicionHistoria {
        public void siguienteEscena() {
            System.out.println("[Transición] La historia avanza a la siguiente escena...");
        }
    }

    public static class DialogoTexto implements GestorDialogo {
        public void mostrarDialogo(String dialogo) {
            System.out.println("[Diálogo] " + dialogo);
        }
    }

    public static class DecisionBinaria implements LogicaDecision {
        private Scanner scanner = new Scanner(System.in);
        public boolean tomarDecision() {
            System.out.println("¿Aceptar misión? (sí/no): ");
            String input = scanner.nextLine().trim().toLowerCase();
            return input.equals("sí") || input.equals("si");
        }
    }

    private TransicionHistoria transicion;
    private GestorDialogo gestorDialogo;
    private LogicaDecision logicaDecision;

    public MainNarrativa(TransicionHistoria transicion, GestorDialogo gestorDialogo, LogicaDecision logicaDecision) {
        this.transicion = transicion;
        this.gestorDialogo = gestorDialogo;
        this.logicaDecision = logicaDecision;
    }

    public void iniciarEscena() {
        gestorDialogo.mostrarDialogo("Bienvenido, héroe. Tu viaje está por comenzar.");

        if (logicaDecision.tomarDecision()) {
            gestorDialogo.mostrarDialogo("Has aceptado la misión. ¡Valentía te define!");
        } else {
            gestorDialogo.mostrarDialogo("Has rechazado la misión. El pueblo recordará tu decisión.");
        }

        transicion.siguienteEscena();
    }

    public static void main(String[] args) {
        TransicionHistoria transicion = new TransicionSimple();
        GestorDialogo gestorDialogo = new DialogoTexto();
        LogicaDecision decision = new DecisionBinaria();

        MainNarrativa juego = new MainNarrativa(transicion, gestorDialogo, decision);
        juego.iniciarEscena();
    }
}