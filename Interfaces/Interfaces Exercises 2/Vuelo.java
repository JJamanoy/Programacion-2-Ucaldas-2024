import java.util.Date;



import java.text.DateFormat;

public class Vuelo{
    private String Num_vuelo="";
    private String Origen="";
    private String Destino="";
    private Date Fecha;
    private int Capacidad=0;
    private int Num_Asientos=0;
    
    public Vuelo(String num_vuelo, String origen, String destino, Date fecha, int capacidad, int num_Asientos) {
        Num_vuelo = num_vuelo;
        Origen = origen;
        Destino = destino;
        Fecha = fecha;
        Capacidad = capacidad;
        Num_Asientos = num_Asientos;
    }

    public String getNum_vuelo() {
        return Num_vuelo;
    }

    public String getOrigen() {
        return Origen;
    }

    public String getDestino() {
        return Destino;
    }

    public Date getFecha() {
        return Fecha;
    }

    public int getCapacidad() {
        return Capacidad;
    }

    public int getNum_Asientos() {
        return Num_Asientos;
    }

    public String formatoFecha() {
        DateFormat formato = DateFormat.getDateInstance();
        return formato.format(Fecha);
    }


    public void setNum_vuelo(String num_vuelo) {
        Num_vuelo = num_vuelo;
    }

    public void setOrigen(String origen) {
        Origen = origen;
    }

    public void setDestino(String destino) {
        Destino = destino;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public void setCapacidad(int capacidad) {
        Capacidad = capacidad;
    }

    public void setNum_Asientos(int num_Asientos) {
        Num_Asientos = num_Asientos;
    }

    @Override
    public String toString() {
        return "   Numero Vuelo: " + Num_vuelo + " | Origen: " + Origen + " | Destino: " + Destino + " | Fecha: " + formatoFecha()
                + " | Capacidad: " + Capacidad + " | Numero de Asientos Ocupados: " + Num_Asientos ;
    }
}