import java.util.Date;

public class Venta {
    Producto producto;
    int cantidad = 0;
    Date fechaVenta;

    public Venta(Producto producto, int cantidad, Date fechaVenta) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.fechaVenta = fechaVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @Override
    public String toString() {
        return "Venta Producto: " + producto + "   Cantidad:" + cantidad + "   Fecha de venta:" + fechaVenta;
    }

}