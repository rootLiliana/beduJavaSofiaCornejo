public class Main {
    public static void main(String[] args) {
        // Crear una declaración de impuestos
        DeclaracionImpuestos declaracion = new DeclaracionImpuestos("ABC123456XYZ", 15000.0);

        // Crear una cuenta fiscal
        CuentaFiscal cuenta = new CuentaFiscal("ABC123456XYZ", 50000.0);

        // Mostrar información de la declaración
        System.out.println("Declaración de Impuestos:");
        System.out.println("RFC: " + declaracion.rfcContribuyente());
        System.out.println("Monto declarado: $" + declaracion.montoDeclarado());

        // Mostrar información de la cuenta fiscal
        System.out.println("\nCuenta Fiscal:");
        System.out.println("RFC: " + cuenta.getRfc());
        System.out.println("Saldo disponible: $" + cuenta.getSaldoDisponible());

        // Validar si el RFC coincide
        boolean coincide = cuenta.validarRFC(declaracion);
        System.out.println("\n¿El RFC de la cuenta coincide con el de la declaración? " + (coincide ? "Sí" : "No"));
    }
}