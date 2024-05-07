public class Reserva{
    private String name_cliente="";
    private String id_cliente="";
    private Vuelo VueloReservado;
    private int AsientosReservados=0;
    public Reserva(String name_cliente, String id_cliente, Vuelo vueloReservado, int asientosReservados) {
        this.name_cliente = name_cliente;
        this.id_cliente = id_cliente;
        VueloReservado = vueloReservado;
        AsientosReservados = asientosReservados;
    }
    public String getName_cliente() {
        return name_cliente;
    }
    public String getId_cliente() {
        return id_cliente;
    }
    public Vuelo getVueloReservado() {
        return VueloReservado;
    }
    public int getAsientosReservados() {
        return AsientosReservados;
    }
    public void setName_cliente(String name_cliente) {
        this.name_cliente = name_cliente;
    }
    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }
    public void setVueloReservado(Vuelo vueloReservado) {
        VueloReservado = vueloReservado;
    }
    public void setAsientosReservados(int asientosReservados) {
        AsientosReservados = asientosReservados;
    }
    
    @Override
    public String toString() {
        return "Reserva a nombre de: " + name_cliente + " / Cedula: " + id_cliente + VueloReservado + " / AsientosReservados: " + AsientosReservados;
    }

    
}