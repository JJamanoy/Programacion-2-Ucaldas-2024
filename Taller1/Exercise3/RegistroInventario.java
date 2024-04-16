import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

public class RegistroInventario {
    static ArrayList<Producto> lista_productos = new ArrayList<>();
    static ArrayList<Categoria> lista_categoria = new ArrayList<>();
    static ArrayList<Proveedor> lista_proveeedor = new ArrayList<>();
    static ArrayList<Venta> lista_venta = new ArrayList<>();
    static ArrayList<Producto> lista_filtro = new ArrayList<>();
    static Date fecha = new Date();
    static Scanner sc = new Scanner(System.in);

    /* Leer Archivo Txt */
    // Este método leera por completo el archivo ed tipo TXT que se disponga y lo
    // separa por los atributos de la clase Producto
    public static void leerArchivoTxt() {
        try (BufferedReader reader = new BufferedReader(new FileReader("lista_productos.txt"))) {
            String linea = "";
            while ((linea = reader.readLine()) != null) {
                String[] bloques = linea.split(",");
                if (bloques.length == 5) {
                    String nombre = bloques[0];
                    String nombre_categoria = bloques[1];
                    String descripcion_categoria = bloques[2];
                    Categoria categoria = new Categoria(nombre_categoria, descripcion_categoria);
                    double precio = Double.parseDouble(bloques[3]);
                    int stock = Integer.parseInt(bloques[4]);
                    lista_productos.add(new Producto(nombre, categoria, precio, stock));
                    lista_categoria.add(categoria);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /* Leer Archivo Txt2 */
    // Este método leera por completo el archivo ed tipo TXT que se disponga y lo
    // separa por los atributos de la clase Producto
    public static void leerArchivoTxt2() {
        try (BufferedReader reader = new BufferedReader(new FileReader("lista_proveedores.txt"))) {
            String linea = "";
            while ((linea = reader.readLine()) != null) {
                String[] bloques = linea.split(",");
                if (bloques.length == 3) {
                    String nombre = bloques[0];
                    String telefono = bloques[1];
                    String direccion = bloques[2];
                    lista_proveeedor.add(new Proveedor(nombre, telefono, direccion));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /* REGISTROS */
    /* registrarProducto */
    // Agrega un producto al registro
    public static void registrarProducto(Producto producto) {
        lista_productos.add(producto);
        System.out.println("Producto añadido al registro.\n");
    }

    /* registrarCategoria */
    // Agrega una categoria al registro
    public static void registrarCategoria(Categoria categoria) {
        lista_categoria.add(categoria);
        System.out.println("Categoria añadida al registro.\n");
    }

    /* registrarProvedor */
    // Agrega un proveedor al registro
    public static void registrarProveedor(Proveedor proveedor) {
        lista_proveeedor.add(proveedor);
        System.out.println("Proveedor añadido al registro\n");
    }

    /* registrarVenta */
    public static void registrarVenta(Venta venta) {
        lista_venta.add(venta);
        System.out.println("Venta añadida al registro\n");
    }

    /* LISTAR */
    /* listarProductos */
    // Imprime en consola todos los productos del registro
    public static void listarProductos() {
        for (Producto productos : lista_productos) {
            System.out.println(productos);
        }
    }

    /* listarCategoria */
    // Imprime en consola todas las categorias del registro
    public static void listarCategoria() {
        HashSet<String> nombresUnicos = new HashSet<>();

        for (Categoria categoria : lista_categoria) {
            if (!nombresUnicos.contains(categoria.getNombre())) {
                System.out.println(categoria);
                nombresUnicos.add(categoria.getNombre());
            }
        }
    }

    /* listarProveedor */
    // Imprime en consola todos los proveedores del registro
    public static void listarProveedores() {
        for (Proveedor proveedor : lista_proveeedor) {
            System.out.println(proveedor);
        }
    }

    /* listarVenta */
    // Imprime en consola todas las ventas del registro
    public static void listarVenta() {
        for (Venta venta : lista_venta) {
            System.out.println(venta);
        }
    }

    /* BUSCAR */
    /* buscarProductos */
    // Con el filtro dado por el usuario, se devuelve una lista de productos que
    // coincidan con el filtro
    public static void buscarProductos() {
        String filtro = "";
        double precio = 0;
        System.out.print("Ingrese el filtro, puede ser el nombre, la categoria del producto o el precio: ");
        filtro = sc.nextLine();

        try {
            precio = Double.parseDouble(filtro);
        } catch (NumberFormatException e) {
        }

        for (int i = 0; i < lista_productos.size(); i++) {
            if (filtro.equals(lista_productos.get(i).getNombre()) ||
                    filtro.equals(lista_productos.get(i).getCategoria().getNombre()) ||
                    precio == lista_productos.get(i).getPrecio()) {
                lista_filtro.add(lista_productos.get(i));
                break;
            }
        }

        System.out.println("Proceso de busqueda terminado");
    }

    /* listarBusqueda */
    // Imprime en consola los elementos de la busqueda
    public static void listarBusqueda() {
        for (Producto producto : lista_filtro) {
            System.out.println(producto);
        }
    }

    /* METODOS EXTERNOS */
    public static Producto crearProducto() {
        String producto_name = "", nombre_categoria = null, descripcion_categoria = null;
        Double precio = 0.0;
        int opcion3 = 0, stock = 0;

        System.out.print("Ingrese el nombre del producto: ");
        producto_name = sc.nextLine();

        System.out.print("¿Desea ingresar la categoria? \n" + "1. SI\n" + "2. NO\n");
        opcion3 = sc.nextInt();
        sc.nextLine();

        if (opcion3 == 1) {
            System.out.print("Ingrese la categoria: ");
            nombre_categoria = sc.nextLine();
            System.out.print("Ingrese la descripcion de la categoria: ");
            descripcion_categoria = sc.nextLine();
        }
        Categoria categoria = null;
        if (nombre_categoria != null && descripcion_categoria != null) {
            categoria = new Categoria(nombre_categoria, descripcion_categoria);
        }

        System.out.print("Ingrese el precio del producto: ");
        precio = sc.nextDouble();
        System.out.print("Ingrese el stock del producto: ");
        stock = sc.nextInt();
        sc.nextLine();

        Producto producto = new Producto(producto_name, categoria, precio, stock);

        return producto;
    }

    public static Categoria crearCategoria() {
        String nombre_categoria = "", descripcion_categoria = "";
        Categoria categoria;

        System.out.print("Ingrese el nombre de la categoria: ");
        nombre_categoria = sc.nextLine();

        System.out.print("Ingrese la descripción de la categoria: ");
        descripcion_categoria = sc.nextLine();

        categoria = new Categoria(nombre_categoria, descripcion_categoria);
        return categoria;
    }

    public static Proveedor crearProveedor() {
        String nombre_proveedor = "", telefono_proveedor = "", direccion = "";
        Proveedor proveedor;
        System.out.print("Ingrese el nombre del proveedor: ");
        nombre_proveedor = sc.nextLine();

        System.out.print("Ingrese el telefono del proveedor: ");
        telefono_proveedor = sc.nextLine();

        System.out.print("Ingrese la dirección del proveedor: ");
        direccion = sc.nextLine();

        proveedor = new Proveedor(nombre_proveedor, telefono_proveedor, direccion);
        return proveedor;

    }

    public static Venta crearVenta() {
        String nombre_producto = "";
        int cantidad = 0, contador = 0, nuevo_elemento = 0;
        Producto producto = null;
        System.out.print("Ingrese el nombre del producto: ");
        nombre_producto = sc.nextLine();

        for (int i = 0; i < lista_productos.size(); i++) {
            if (nombre_producto.equals(lista_productos.get(i).getNombre())) {
                producto = lista_productos.get(i);
                contador = i;
            }
        }

        if (producto == null) {
            System.out.print("No existe el producto");
            return null;
        }

        System.out.print("Ingrese la cantidad de venta: ");
        cantidad = sc.nextInt();

        if (cantidad > lista_productos.get(contador).getStock()) {
            System.out.println("No hay suficiente stock");
            return null;
        }

        nuevo_elemento = lista_productos.get(contador).getStock();
        lista_productos.get(contador).setStock(nuevo_elemento);
        Venta venta = new Venta(producto, cantidad, fecha);
        return venta;
    }

    /* Producto con menor stock */
    public static void ProductoMenor() {
        int pro_menor = lista_productos.get(0).getStock();
        String pro_nombre = lista_productos.get(0).getNombre();

        for (int i = 0; i < lista_productos.size(); i++) {
            if (lista_productos.get(i).getStock() < pro_menor) {
                pro_menor = lista_productos.get(i).getStock();
                pro_nombre = lista_productos.get(i).getNombre();
            }
        }

        System.out.println("El producto con menor cantidad de unidades es " + pro_nombre + " con " + pro_menor);
    }

    /* Menú */
    // Menú principal del sistema
    public static void menuProducto() {
        int opcion = 0, opcion2 = 0;

        do {
            System.out.println("SISTEMA DE INVENTARIO");
            System.out.println("1. Registros");
            System.out.println("2. Listar");
            System.out.println("3. Buscar");
            System.out.println("4. Salir del programa");
            System.out.print("Ingrese el indice de la opción que desea: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    Producto producto;
                    Proveedor proveedor;
                    Categoria categoria;
                    Venta venta;
                    System.out.println("REGISTROS");
                    System.out.println("1. Registrar producto");
                    System.out.println("2. Registrar una categoria");
                    System.out.println("3. Registrar proveedor");
                    System.out.println("4. Registrar venta");
                    System.out.println("5. Salir al menú principal");
                    System.out.print("Ingrese el indice de la opción que desea: ");
                    opcion2 = sc.nextInt();
                    sc.nextLine();

                    switch (opcion2) {
                        case 1:
                            producto = crearProducto();
                            registrarProducto(producto);
                            break;

                        case 2:
                            categoria = crearCategoria();
                            registrarCategoria(categoria);
                            break;

                        case 3:
                            proveedor = crearProveedor();
                            registrarProveedor(proveedor);
                            break;

                        case 4:
                            venta = crearVenta();
                            registrarVenta(venta);
                            break;

                        case 5:
                            break;

                        default:
                            System.out.println("Opción incorrecta. Volviendo al menú principal");

                    }
                    break;

                case 2:
                    System.out.println("LISTAR");
                    System.out.println("1. Listar productos");
                    System.out.println("2. Listar categorias");
                    System.out.println("3. Listar proveedores");
                    System.out.println("4. Listar ventas");
                    System.out.println("5. Salir al menú principal");
                    System.out.print("Ingrese el indice de la opción que desea: ");
                    opcion2 = sc.nextInt();
                    sc.nextLine();

                    switch (opcion2) {
                        case 1:
                            listarProductos();
                            break;

                        case 2:
                            listarCategoria();
                            break;

                        case 3:
                            listarProveedores();
                            break;

                        case 4:
                            listarVenta();
                            break;

                        case 5:
                            break;
                    }
                    break;

                case 3:
                    buscarProductos();
                    listarBusqueda();
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Opción incorrecta. Volviendo al menú principal");
            }
        } while (opcion != 4);
    }
}