import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class RegistroBiblioteca {
    static ArrayList<Libro> registro_libros = new ArrayList<>();
    static ArrayList<Autor> registro_autores = new ArrayList<>();
    static ArrayList<Prestamo> registro_prestamo = new ArrayList<>();
    static ArrayList<Libro> lista_filtros = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static Date fecha = new Date();

    /* Leer Archivo Txt */
    // Este método leer por completo el archivo de tipo TXT que se disponga y lo
    // separa por los atributos de la clase
    // Libro
    public static void leerArchivoTxt() {
        try (BufferedReader reader = new BufferedReader(new FileReader("registro_libros.txt"))) {
            String linea = "";
            while ((linea = reader.readLine()) != null) {
                String[] bloques = linea.split(",");
                if (bloques.length == 6) {
                    String title = bloques[0];
                    String nombre_autor = bloques[1];
                    String nacionalidad_autor = bloques[2];
                    Autor autor = new Autor(nombre_autor, nacionalidad_autor);
                    String isbn = bloques[3];
                    String categoria = bloques[4];
                    int ejemplares = Integer.parseInt(bloques[5]);
                    registro_libros.add(new Libro(title, autor, isbn, categoria, ejemplares));
                    registro_autores.add(new Autor(nombre_autor, nacionalidad_autor));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /* REGISTROS */
    /* registrarLibro */
    // Agrega un libro al registro
    public static void registrarLibro(Libro libro) {
        registro_libros.add(libro);
    }

    /* registrarAutor */
    // Agrega un autor al registro
    public static void registrarAutor(Autor autor) {
        registro_autores.add(autor);
    }

    /* registrarPrestamo */
    // Registra el prestamo de un libro y corrobora que no tenga un prestamo vencido
    // o que haya ejemplares disponibles
    public static void registrarPrestamo(Prestamo prestamo) {
        int fecha_resultado = 0, nuevo_ejemplar = 0, c = 0;

        if (prestamo.getLibro().getEjemplares() > 0) {
            for (int i = 0; i < registro_prestamo.size(); i++) {
                Prestamo prestamoExistente = registro_prestamo.get(i);
                c = i;
                if (prestamo.getUsuario().getNombre().equals(prestamoExistente.getUsuario().getNombre())) {
                    fecha_resultado = fecha.compareTo(prestamoExistente.getFechaDevolucion());
                    if (fecha_resultado < 0) {
                        System.out.println("Tiene un préstamo vencido");
                        return;
                    } else if (fecha_resultado == 0) {
                        System.out.println("Hoy vence un préstamo anterior");
                        return;
                    }
                }
            }

            registro_prestamo.add(prestamo);
            nuevo_ejemplar = prestamo.getLibro().getEjemplares() - 1;
            registro_libros.get(c).setEjemplares(nuevo_ejemplar);
            System.out.println("Préstamo añadido");
        } else {
            System.out.println("No hay ejemplares disponibles para este libro");
        }
    }

    /* RegistrarDevolucion */
    // Registra la devolución de un libro
    public static void registrarDevolución(Prestamo prestamo) {
        for (int i = 0; i < registro_prestamo.size(); i++) {
            if (prestamo.getUsuario().getNombre().equals(registro_prestamo.get(i).getUsuario().getNombre())
                    && prestamo.getUsuario().getCedula().equals(registro_prestamo.get(i).getUsuario().getCedula())) {
                if (prestamo.getLibro().getIsbn().equals(registro_prestamo.get(i).getLibro().getIsbn())) {
                    registro_prestamo.remove(i);
                    System.out.println("Devolución hecha.");
                }
            }
        }
    }

    /* LISTAR */
    /* listarLibros */
    // Imprime todos los libros registrados
    public static void listarLibros() {
        for (Libro libro : registro_libros) {
            System.out.println(libro);
        }
    }

    /* listarAutores */
    // Imprime todos los autores guardados
    public static void listarAutores() {
        for (Autor autor : registro_autores) {
            System.out.println(autor);
        }
    }

    /* listarPrestamos */
    // Imprime todos los prestamos actuales y vencidos
    public static void listarPrestamos() {
        for (int i = 0; i < registro_prestamo.size(); i++) {
            System.out.println(registro_prestamo.get(i));
        }
    }

    /* BUSCAR */
    /* buscarLibros */
    // Busca y retorna una lista de libros que coincidan con el filtro
    public static ArrayList<Libro> buscarLibros(String filtro) {
        for (int i = 0; i < registro_libros.size(); i++) {
            if (filtro.equals(registro_libros.get(i).getTitulo())) {
                lista_filtros.add(registro_libros.get(i));
            } else if (filtro.equals(registro_libros.get(i).getAutor().getNombre())) {
                lista_filtros.add(registro_libros.get(i));
            } else if (filtro.equals(registro_libros.get(i).getAutor().getNacionalidad())) {
                lista_filtros.add(registro_libros.get(i));
            } else if (filtro.equals(registro_libros.get(i).getIsbn())) {
                lista_filtros.add(registro_libros.get(i));
            } else if (filtro.equals(registro_libros.get(i).getCategoria())) {
                lista_filtros.add(registro_libros.get(i));
            }
        }
        System.out.println("Proceso terminado");
        return lista_filtros;
    }

    /* listarBusqueda */
    // Lista todos los elementos de la busqueda
    public static void listarBusqueda(ArrayList<Libro> lista_filtro) {
        for (Libro contador : lista_filtro) {
            System.out.println(contador);
        }
    }

    /* METODOS EXTERNOS */
    /* crearLibro */
    // Este método simplifica el codigo ya que con este se crea un libro
    public static Libro crearLibro() {
        String title = "", nombre_autor = null, nacionalidad_autor = null, isbn = "", categoria = "";
        int ejemplares = 0, opcion3 = 0;
        System.out.print("Titulo del libro: ");
        title = sc.nextLine();

        System.out.print("¿Desea ingresar el autor? \n" + "1. SI\n" + "2. NO\n");
        opcion3 = sc.nextInt();
        sc.nextLine();
        if (opcion3 == 1) {
            System.out.print("Ingrese el autor: ");
            nombre_autor = sc.nextLine();
            System.out.print("Ingrese la nacionalidad del autor: ");
            nacionalidad_autor = sc.nextLine();
        }
        Autor autor = null;
        if (nombre_autor != null && nacionalidad_autor != null) {
            autor = new Autor(nombre_autor, nacionalidad_autor);
        }
        System.out.print("Ingrese el ISBN del libro: ");
        isbn = sc.nextLine();
        System.out.print("Ingrese la categoria: ");
        categoria = sc.nextLine();
        System.out.print("Ingrese el número de ejemplares: ");
        ejemplares = sc.nextInt();
        sc.nextLine();

        Libro libro = new Libro(title, autor, isbn, categoria, ejemplares);

        return libro;
    }

    /* crearAutor */
    // Este método simplifica el codigo ya que con este se crea un autor
    public static Autor crearAutor() {
        String name_autor = "", nacionality_autor = "";
        System.out.print("Nombre del autor: ");
        name_autor = sc.nextLine();
        System.out.print("Nacionalidad del autor: ");
        nacionality_autor = sc.nextLine();

        Autor autor = new Autor(name_autor, nacionality_autor);

        return autor;
    }

    /* crearUsuario */
    // Este método simplifica el codigo ya que con este se crea un usuario
    public static Usuario crearUsuario() {
        String nombre = "", cedula = "";
        System.out.print("Ingrese el nombre del usuario: ");
        nombre = sc.nextLine();
        System.out.print("Ingrese la cedula del usuario: ");
        cedula = sc.nextLine();

        Usuario user = new Usuario(nombre, cedula);
        return user;
    }

    /* crearPrestamo */
    // Este método simplifica el codigo ya que con este se crea un prestamo
    public static Prestamo crearPrestamo() {
        Libro libro;
        Usuario user;
        Date fecha, fecha_dev;

        System.out.println("        SISTEMA DE PRESTAMO\n" + "        Registro");
        libro = crearLibro();
        user = crearUsuario();
        System.out.println("Ingrese la fecha actual");
        fecha = crearFecha();
        System.out.println("Ingrese la fecha de devolución");
        fecha_dev = crearFecha();

        Prestamo prestamo = new Prestamo(libro, user, fecha, fecha_dev);
        return prestamo;
    }

    /* crearDevolución */
    // Este método simplifica el codigo ya que con este se crea una petición de
    // devolución
    public static Prestamo crearDevolucion() {
        String user = "", cedula = "", tituloLibro = "";
        Libro libro = null;
        Date fecha = null, fecha_dev = null;
        Prestamo prestamo = null;
        Usuario usuario = null;

        System.out.print("Ingrese el nombre del usuario: ");
        user = sc.nextLine();
        System.out.print("Ingrese la cedula del usuario: ");
        cedula = sc.nextLine();

        for (int i = 0; i < registro_prestamo.size(); i++) {
            if (user.equals(registro_prestamo.get(i).getUsuario().getNombre()) &&
                    cedula.equals(registro_prestamo.get(i).getUsuario().getCedula())) {
                usuario = registro_prestamo.get(i).getUsuario();

                System.out.print("Ingrese el título del libro que será devuelto: ");
                tituloLibro = sc.nextLine();

                for (int j = 0; j < registro_libros.size(); j++) {
                    if (tituloLibro.equals(registro_libros.get(j).getTitulo())) {
                        libro = registro_libros.get(j);
                        prestamo = new Prestamo(libro, usuario, fecha, fecha_dev);
                        return prestamo;
                    }
                }

                System.out.println("No se encontró el libro en nuestro registro.");
                return null;
            }
        }

        System.out.println("No se encontró el usuario.");
        return null;
    }

    /* crearFecha */
    // Este método crea la fecha que el usuario quiera
    public static Date crearFecha() {
        int dia = 0, mes = 0, anio = 0;
        System.out.println("Ingrese el dia: ");
        dia = sc.nextInt();

        System.out.println("Ingrese mes: ");
        mes = sc.nextInt();
        mes--;

        System.out.println("Ingrese año: ");
        anio = sc.nextInt();
        anio -= 1990;

        Date fecha = new Date(anio, mes, dia);
        return fecha;
    }

    /* crearFiltro */
    // Este método simplifica el codigo ya que con este se crea un String filtro
    public static String crearFiltro() {
        String filtro = "";
        System.out.println(
                "Ingrese la palabra clave para buscar, puede ser por el titulo, autor, ISBN o la categoria del libro");
        filtro = sc.nextLine();

        return filtro;
    }

    public static void librosmayor() {
        int ejem_comparar = registro_libros.get(0).getEjemplares();
        ArrayList<Libro> lista_libros_mayor = new ArrayList<>();
        for (int i = 0; i < registro_libros.size(); i++) {
            if (ejem_comparar < registro_libros.get(i).getEjemplares()) {
                ejem_comparar = registro_libros.get(i).getEjemplares();
            }
        }

        System.out.println("TITULOS CON MAYOR CANTIDAD");
        for (int i = 0; i < registro_libros.size(); i++) {
            if (ejem_comparar == registro_libros.get(i).getEjemplares()) {
                System.out.println(registro_libros.get(i).getTitulo());
            }
        }

    }

    /* Menú */
    public static void menuLibro() {
        int opcion = 0;
        do {
            System.out.println(" Gestión Bilblioteca");
            System.out.println("1. Crear registros");
            System.out.println("2. Ver Registros");
            System.out.println("3. Buscar libros");
            System.out.println("4. Salir");
            System.out.print("Ingrese el indice de la opción que desea: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    int opcion2 = 0;
                    String filtro = "";
                    Libro libro;
                    Autor autor;
                    Usuario user;
                    Date fecha, fecha_dev;
                    Prestamo prestamo, devolucion;

                    System.out.println("CREAR REGISTROS");
                    System.out.println("1. Registro libro");
                    System.out.println("2. Registrar autor");
                    System.out.println("3. Registrar préstamo");
                    System.out.println("4. Registrar devolución");
                    System.out.println("5. Salir al menú");
                    System.out.print("Indique el indice del registro que desea hacer: ");
                    opcion2 = sc.nextInt();
                    sc.nextLine();
                    switch (opcion2) {
                        case 1:
                            libro = crearLibro();
                            registrarLibro(libro);
                            System.out.println("Libro añadido");
                            break;

                        case 2:
                            autor = crearAutor();
                            registrarAutor(autor);
                            System.out.println("Autor añadido");
                            break;

                        case 3:
                            prestamo = crearPrestamo();
                            registrarPrestamo(prestamo);
                            break;

                        case 4:
                            devolucion = crearDevolucion();
                            if (devolucion == null) {
                                break;
                            }
                            registrarDevolución(devolucion);
                            break;

                        case 5:
                            break;
                        default:
                            System.out.println("Opción incorrecta. Volviendo al menú principal");
                    }
                    break;

                case 2:

                    System.out.println("VER REGISTROS");
                    System.out.println("1. Ver registro de libros");
                    System.out.println("2. Ver registro de autores");
                    System.out.println("3. Ver registro de prestamo");
                    System.out.println("4. Salir al menú");
                    System.out.print("Indique el indice del registro que desea hacer: ");
                    opcion2 = sc.nextInt();

                    switch (opcion2) {
                        case 1:
                            listarLibros();
                            break;

                        case 2:
                            listarAutores();
                            break;

                        case 3:
                            listarPrestamos();
                            break;

                        case 4:
                            break;

                        default:
                            System.out.println("Opción incorrecta. Volviendo al menú principal");
                            break;
                    }
                    break;
                case 3:
                    filtro = crearFiltro();
                    lista_filtros = buscarLibros(filtro);
                    listarBusqueda(lista_filtros);
                    break;
                case 4:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción incorrecta. Volviendo al menú principal");
            }
        } while (opcion != 4);
    }
}