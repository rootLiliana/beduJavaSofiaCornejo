class Entrada {
    String evento;
    double precio;

    //Constructor
    public Entrada(String evento, double precio) {
        this.evento = evento;
        this.precio = precio;
    }

    // Método para mostrar los datos de la entrada
    public void mostrarInformation() {
        System.out.println("Evento: " + evento + " | Precio: $" + precio);
    }
}