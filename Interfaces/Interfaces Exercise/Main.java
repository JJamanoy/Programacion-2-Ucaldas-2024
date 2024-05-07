import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        ImplementacionInventario instancia = new ImplementacionInventario();
        ArrayList<Producto> ListaProductos = instancia.obtenerProductos();
        for (Producto producto : ListaProductos) {
            System.out.println("Nombre: "+producto.getName()+"   Precio: "+producto.getPrice()+"   Stock: "+producto.getStock());
        }
    }
}