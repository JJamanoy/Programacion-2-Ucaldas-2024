import java.util.ArrayList;

public class ImplementacionInventario implements Inventario{
    
    public ArrayList<Producto> ListaProductos = new ArrayList<>();

    public ImplementacionInventario(){
        this.ListaProductos.add(new Producto("Jabon FAB", 75000, 5));
        this.ListaProductos.add(new Producto("Jabon Ariel", 70000, 15));
        this.ListaProductos.add(new Producto("Jabon Rey", 80000, 50));
    }

    public ArrayList<Producto> obtenerProductos() {
        return this.ListaProductos;
    }

}
