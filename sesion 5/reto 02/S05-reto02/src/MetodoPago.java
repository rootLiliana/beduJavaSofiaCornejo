// Interfaz Autenticable
interface Autenticable {
    boolean autenticar();
}

// Clase abstracta MetodoPago
abstract class MetodoPago {
    protected double monto;

    public MetodoPago(double monto) {
        this.monto = monto;
    }

    public abstract void procesarPago();

    public void mostrarResumen() {
        System.out.println("Tipo de pago: " + this.getClass().getSimpleName());
        System.out.println("Monto: $" + monto);
    }
}

// Clase PagoEfectivo
class PagoEfectivo extends MetodoPago implements Autenticable {

    public PagoEfectivo(double monto) {
        super(monto);
    }

    @Override
    public boolean autenticar() {
        return true; // No requiere validación
    }

    @Override
    public void procesarPago() {
        if (autenticar()) {
            System.out.println("Pago en efectivo procesado correctamente.");
        }
    }
}

// Clase PagoTarjeta
class PagoTarjeta extends MetodoPago implements Autenticable {
    private double saldoDisponible;

    public PagoTarjeta(double monto, double saldoDisponible) {
        super(monto);
        this.saldoDisponible = saldoDisponible;
    }

    @Override
    public boolean autenticar() {
        return saldoDisponible >= monto;
    }

    @Override
    public void procesarPago() {
        if (autenticar()) {
            saldoDisponible -= monto;
            System.out.println("Pago con tarjeta procesado correctamente.");
        } else {
            System.out.println("Fondos insuficientes para el pago con tarjeta.");
        }
    }
}

// Clase PagoTransferencia
class PagoTransferencia extends MetodoPago implements Autenticable {

    public PagoTransferencia(double monto) {
        super(monto);
    }

    @Override
    public boolean autenticar() {
        // Simulación de validación bancaria
        System.out.println("Validando con el banco...");
        return Math.random() > 0.2; // 80% de probabilidad de éxito
    }

    @Override
    public void procesarPago() {
        if (autenticar()) {
            System.out.println("Pago por transferencia procesado correctamente.");
        } else {
            System.out.println("Error en la validación bancaria.");
        }
    }
}