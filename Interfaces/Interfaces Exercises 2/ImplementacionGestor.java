import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ImplementacionGestor implements GestorVuelos {

    public ArrayList<Vuelo> ListaVuelos = new ArrayList<>();
    public ArrayList<Reserva> ListaReservas = new ArrayList<>();
    public Scanner sc = new Scanner(System.in);

    public ImplementacionGestor() {
        Date fechaVuelo1234 = new Date(124, 3, 24);
        this.ListaVuelos.add(new Vuelo("1234", "Manizales", "Bogota", fechaVuelo1234, 150, 75));
        Date fechaVuelo5678 = new Date(124, 3, 30);
        this.ListaVuelos.add(new Vuelo("5678", "Manizales", "Medellin", fechaVuelo5678, 125, 80));
        Date fechaVuelo9876 = new Date(124, 4, 05);
        this.ListaVuelos.add(new Vuelo("9876", "Medellin", "Bogota", fechaVuelo9876, 200, 100));
    }

    public ArrayList<Vuelo> obtenerVuelos() {
        return this.ListaVuelos;
    }

    public ArrayList<Reserva> obtenerReservas() {
        return this.ListaReservas;
    }

    public void showVuelos(ArrayList<Vuelo> ListaVuelos) {
        if (ListaVuelos.size() > 0) {

            for (Vuelo vuelo : ListaVuelos) {
                System.out.println(vuelo);
            }
        }
    }

    public void showReservas(ArrayList<Reserva> ListaReservas) {
        for (Reserva reserva : ListaReservas) {
            System.out.println(reserva);
        }
    }

    public Reserva addReserva() {
        String name_cliente = "", id_cliente = "", num_vuelo = "";
        int asientos_cliente = 0;
        Vuelo vuelo_cliente = null;

        System.out.print("Ingrese nombre del cliente: ");
        name_cliente = sc.nextLine();
        System.out.print("Ingrese la cedula del cliente: ");
        id_cliente = sc.nextLine();

        System.out.println("LISTA VUELOS");
        showVuelos(ListaVuelos);
        System.out.println();
        System.out.print("Ingrese el nùmero de vuelo que desea escoger: ");
        num_vuelo = sc.nextLine();

        for (Vuelo vuelo : ListaVuelos) {
            if (num_vuelo.equals(vuelo.getNum_vuelo())) {
                vuelo_cliente = vuelo;
                break;
            }
        }

        if (vuelo_cliente == null) {
            System.out.println("No es posible comprar boletos de este vuelo");
            return null;
        }

        System.out.print("Ingrese el nùmero de puestos que desea adquirir: ");
        asientos_cliente = sc.nextInt();
        sc.nextLine();

        int asientos_disponibles = (vuelo_cliente.getCapacidad() - vuelo_cliente.getNum_Asientos());
        if (asientos_cliente > asientos_disponibles) {
            System.out
                    .println("No se pueden comprar màs asientos de los disponibles, que son: " + asientos_disponibles);
            return null;
        }

        int indiceVuelo = ListaVuelos.indexOf(vuelo_cliente);
        ListaVuelos.get(indiceVuelo).setNum_Asientos(vuelo_cliente.getNum_Asientos() + asientos_cliente);

        Reserva reserva = new Reserva(name_cliente, id_cliente, vuelo_cliente, asientos_cliente);
        System.out.println("Reserva Registrada");
        return reserva;
    }

    public void removeReserva() {
        String cedula_vuelo = "";
        boolean verificate = false;
        showReservas(ListaReservas);
        System.out.print("Ingrese la cedula de la persona desea eliminar el vuelo: ");
        cedula_vuelo = sc.nextLine();

        for (Reserva reserva : ListaReservas) {
            if (cedula_vuelo.equals(reserva.getId_cliente())) {
                ListaReservas.remove(reserva);
                System.out.println("Reserva eliminada");
                verificate = true;
                break;
            }
        }

        if (!verificate ) {
            System.out.println("No se elimino la reserva porque no se encontro.");
            return;
        }
    }

    public void menu() {
        int opcion = 0;

        do {
            System.out.println("SISTEMA DE RESERVAS DE VUELOS");
            System.out.print(
                    "1. Reservar un vuelo\n2. Cancelar una reserva\n3. Ver los vuelos disponibles\nIngrese la opción que desea: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    Reserva reserva = addReserva();
                    ListaReservas.add(reserva);
                    System.out.println("RESERVAS HECHAS");
                    showReservas(ListaReservas);
                    System.out.println();
                    break;

                case 2:
                    removeReserva();
                    System.out.println("RESERVAS HECHAS");
                    showReservas(ListaReservas);
                    System.out.println();
                    break;

                case 3:
                    showVuelos(ListaVuelos);
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Ingrese una opcion correcta");
                    break;
            }
        } while (opcion != 4);
    }
}