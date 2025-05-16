import java.util.Optional;

public class Factura {
    private double monto;
    private String descripcion;
    private Optional<String> rfc;

    // Constructor
    public Factura(double monto, String descripcion, String rfc) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.rfc = Optional.ofNullable(rfc); // Maneja null de forma segura
    }

    // Método para obtener un resumen de la factura
    public String getResumen() {
        String resumen = "Descripción: " + descripcion +
                "\nMonto: $" + monto +
                "\nRFC: " + rfc.orElse("[No proporcionado]");
        return resumen;
    }
}