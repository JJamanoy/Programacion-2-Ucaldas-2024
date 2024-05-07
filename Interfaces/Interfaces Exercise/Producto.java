public class Producto{

    private String name="";
    private float price=0.0f;
    private int stock=0;
    
    public Producto(String name, float price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public String getName() {
        return name;
    }
    public float getPrice() {
        return price;
    }
    public int getStock() {
        return stock;
    }


    
}