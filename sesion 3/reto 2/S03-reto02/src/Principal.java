public class Principal {
    public static void main(String[] args) {
        // Factura con RFC
        Factura facturaConRFC = new Factura(1200.50, "Compra de laptop", "ABC123456789");

        // Factura sin RFC (null)
        Factura facturaSinRFC = new Factura(850.75, "Compra de impresora", null);

        // Imprimir resúmenes
        System.out.println("Factura 1:");
        System.out.println(facturaConRFC.getResumen());

        System.out.println("\nFactura 2:");
        System.out.println(facturaSinRFC.getResumen());
    }
}