import java.util.ArrayList;

public interface GestorVuelos{

    ArrayList<Vuelo> obtenerVuelos();
    ArrayList<Reserva> obtenerReservas();
    void showVuelos(ArrayList<Vuelo> ListaVuelos);
    void showReservas(ArrayList<Reserva> ListaReservas);
    Reserva addReserva();
    void removeReserva();
    void menu();
}