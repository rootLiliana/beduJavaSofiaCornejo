public class Main {
    public static void main(String [] args) {
        //Crear un pasajero
        Pasajero pasajero = new Pasajero("Sofia Cornejo", "p123456");

        //Crear un vuelo
        Vuelo vuelo = new Vuelo("ux123","Ecuador","14:30");

        //Reservar asiento
        boolean reservado = vuelo.reservarAsiento(pasajero);
        if (reservado) {
            System.out.println("Reserva realiza con exito.\n");
        }else {
            System.out.println("No se pudo realizar la reerva.\n");
        }

        //Mostrar Itinerario
        System.out.println(vuelo.obtenerItinerario());

        //Cancelar reserva
        System.out.println(vuelo.obtenerItinerario());

        //Cancelar reserva
        System.out.println("Cancelando reserva...\n");
        vuelo.cancelarReserva();

        //Mostrar itinerario actualizado
        System.out.println(vuelo.obtenerItinerario());

        //Realizamos una nueva reservacion
        vuelo.reservarAsiento("Alejandra Imba","P987654");
        System.out.println(vuelo.obtenerItinerario());
    }
}