class Principal {
    public static void main(String[] args) {
        Entrada entrada1 = new Entrada("Concierto de BEDU", 800.00);
        Entrada entrada2 = new Entrada("Obra de teatro de BEDU", 450.50);

        entrada1.mostrarInformation();
        entrada2.mostrarInformation();

        // Reto adicional
        Entrada_Record entrada3 = new Entrada_Record("Sinfonica de BEDU", 1280.00);
        entrada3.mostrarInformacion();
    }
}