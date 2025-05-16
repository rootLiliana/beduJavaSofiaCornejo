public class CajaRegistradora {
    public static void main(String[] args) {
        MetodoPago[] pagos = new MetodoPago[] {
                new PagoEfectivo(100),
                new PagoTarjeta(250, 300),
                new PagoTarjeta(500, 100), // Fondos insuficientes
                new PagoTransferencia(150),
                new PagoTransferencia(80)
        };

        for (MetodoPago pago : pagos) {
            System.out.println("---- Procesando pago ----");

            // Verificamos que el objeto sea Autenticable
            if (pago instanceof Autenticable) {
                Autenticable autenticable = (Autenticable) pago;

                if (autenticable.autenticar()) {
                    pago.procesarPago();
                    pago.mostrarResumen();
                } else {
                    System.out.println("Autenticación fallida. No se puede procesar el pago.");
                }
            } else {
                System.out.println("Este método de pago no implementa autenticación.");
            }

            System.out.println();
        }
    }
}