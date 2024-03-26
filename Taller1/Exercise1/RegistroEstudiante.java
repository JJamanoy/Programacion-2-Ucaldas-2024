import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RegistroEstudiante {

    static ArrayList<Estudiante> lista_estudiantes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    /* LeerArchivoTxt */
    // Este método leer por completo el archivo de tipo TXT que se disponga y lo
    // separa por los atributos de la clase
    // Estudiante
    public static void leerArchivoTxt() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Lista_Estudiantes.txt"))) {
            String linea = "";
            while ((linea = reader.readLine()) != null) {
                String[] bloques = linea.split(",");
                if (bloques.length == 4) {
                    String nombre = bloques[0];
                    String codigo = bloques[1];
                    String carrera = bloques[2];
                    Double promedio = Double.parseDouble(bloques[3]);
                    lista_estudiantes.add(new Estudiante(nombre, codigo, carrera, promedio));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

    }

    /* agregarEstudiante */
    // Este método añade un estudiante a la lista
    public static void agregarEstudiante(Estudiante estudiante) {
        lista_estudiantes.add(estudiante);
        System.out.println("Estudiante agregado.");

    }

    /* eliminarEstudiante */
    // Este método elimina un estudiante por su codigo
    public static void eliminarEstudiante(String codigo) {

        for (int c = lista_estudiantes.size() - 1; c >= 0; c--) {
            if (codigo.equals(lista_estudiantes.get(c).getCodigo())) {
                lista_estudiantes.remove(c);
                System.out.println("Estudiante eliminado");
            }
        }

    }

    /* listarEstudiante */
    // Esta función muestra todos los estudiantes
    public static void listarEstudiantes(ArrayList<Estudiante> lista_estudiantes) {
        System.out.println("Lista de estudiantes");
        for (Estudiante estudiantes : lista_estudiantes) {
            System.out.println(estudiantes);
        }
    }

    /* buscarEstudiante */
    // Busca los estudiantes que se pongan en el filtro y los devuelve en una lista
    public static ArrayList<Estudiante> buscarEstudiantes(String filtro) {
        ArrayList<Estudiante> lista_filtros = new ArrayList<>();

        for (int i = 0; i < lista_estudiantes.size(); i++) {
            if (filtro.equals(lista_estudiantes.get(i).getNombre())) {
                lista_filtros.add(lista_estudiantes.get(i));
            } else if (filtro.equals(lista_estudiantes.get(i).getCodigo())) {
                lista_filtros.add(lista_estudiantes.get(i));
            } else if (filtro.equals(lista_estudiantes.get(i).getCarrera())) {
                lista_filtros.add(lista_estudiantes.get(i));
            }
        }
        System.out.println("Proceso terminado.");
        return lista_filtros;
    }

    /* Menú */
    public static void menuEstudiantes() {

        int opcion = 0;
        do {
            System.out.println("PROGRAMA CONTROL DE ESTUDIANTES");
            System.out.println("1. Agregar estudiante(s)");
            System.out.println("2. Eliminar estudiante(s)");
            System.out.println("3. Ver todos los estudiante(s)");
            System.out.println("4. Ver estudiante(s) segun filtro");
            System.out.println("5. Salir del programa");
            System.out.print("Escriba el índice para el menú que desea: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    /* Declaración Variables */
                    String name_student = "", code_student = "", career_student = "";
                    Double average_student = 0.0;
                    System.out.print("Ingrese el nombre del estudiante: ");
                    name_student = sc.nextLine();

                    System.out.print("Ingrese el codigo del estudiante: ");
                    code_student = sc.nextLine();

                    System.out.print("Ingrese la carrera a la que esta adscrito el estudiante: ");
                    career_student = sc.nextLine();

                    System.out.print("Ingrese el promedio del estudiante(Separado por punto. Ejemplo: 4.5): ");
                    average_student = Double.parseDouble(sc.nextLine());

                    agregarEstudiante(new Estudiante(name_student, code_student, career_student, average_student));
                    break;
                case 2:
                    String codigo = "";
                    System.out.print("Ingrese el codigo del estudiante para eliminarlo: ");
                    codigo = sc.nextLine();
                    eliminarEstudiante(codigo);
                    break;
                case 3:
                    listarEstudiantes(lista_estudiantes);
                    break;
                case 4:
                    String filtro = "";
                    System.out.print("Escriba el nombre, codigo o carrera del estudiante: ");
                    filtro = sc.nextLine();
                    listarEstudiantes(buscarEstudiantes(filtro));
                    break;
                case 5:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        } while (opcion < 5 && opcion > 0);
    }
}