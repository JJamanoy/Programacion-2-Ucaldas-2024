import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Seminars{
    
    static ArrayList <CourseInformation> courses_programacion = new ArrayList<>();
    static ArrayList <CourseInformation> courses_fisica = new ArrayList<>();
    static ArrayList <CourseInformation> courses_matematicas = new ArrayList<>();
    static ArrayList <Professor> professors_list = new ArrayList<>();
    static Scanner sc = new Scanner (System.in);


    /* TXT PROGRAMACIÓN */
    public static void leerArchivoTxtProg() {
        try (BufferedReader reader = new BufferedReader(new FileReader("MateriasProgramacion.txt"))) {
            String linea = "";
            while ((linea = reader.readLine()) != null) {
                String[] bloques = linea.split(",");
                if (bloques.length == 5) {
                    String name = bloques[0];
                    int hours = Integer.parseInt(bloques[1]);
                    String name_professor = bloques[2];
                    String telephone = bloques[3];
                    String correo = bloques[4];
                    Professor professor = new Professor(name_professor, telephone, correo);
                    professors_list.add(professor);
                    courses_programacion.add(new CourseInformation(name, hours, professor));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /* TXT FISICA */
    public static void leerArchivoTxtFis() {
        try (BufferedReader reader = new BufferedReader(new FileReader("MateriasFisica.txt"))) {
            String linea = "";
            while ((linea = reader.readLine()) != null) {
                String[] bloques = linea.split(",");
                if (bloques.length == 5) {
                    String name = bloques[0];
                    int hours = Integer.parseInt(bloques[1]);
                    String name_professor = bloques[2];
                    String telephone = bloques[3];
                    String correo = bloques[4];
                    Professor professor = new Professor(name_professor, telephone, correo);
                    professors_list.add(professor);
                    courses_fisica.add(new CourseInformation(name, hours, professor));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /* TXT MATEMATICAS */
    public static void leerArchivoTxtMat() {
        try (BufferedReader reader = new BufferedReader(new FileReader("MateriasMatematicas.txt"))) {
            String linea = "";
            while ((linea = reader.readLine()) != null) {
                String[] bloques = linea.split(",");
                if (bloques.length == 5) {
                    String name = bloques[0];
                    int hours = Integer.parseInt(bloques[1]);
                    String name_professor = bloques[2];
                    String telephone = bloques[3];
                    String correo = bloques[4];
                    Professor professor = new Professor(name_professor, telephone, correo);
                    professors_list.add(professor);
                    courses_matematicas.add(new CourseInformation(name, hours, professor));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /* LISTAR MATERIAS PROGRAMACION  */
    public void watchSeminarProg(){
        int i=1;
        for (CourseInformation courseInformation : courses_programacion) {
            System.out.println(i+" "+courseInformation);
            i++;
        }
    }

    /* LISTAR MATERIAS FISICA  */
    public void watchSeminarFis(){
        int i=1;
        for (CourseInformation courseInformation : courses_fisica) {
            System.out.println(i+" "+courseInformation);
            i++;
        }
    }

    /* LISTAR MATERIAS MATEMATICAS  */
    public void watchSeminarMat(){
        int i=1;
        for (CourseInformation courseInformation : courses_matematicas) {
            System.out.println(i+" "+courseInformation);
            i++;
        }
    }
    
    public CourseInformation course_info(){
        int indice=0;
        String name="";
        CourseInformation courseInformation= null;
        System.out.println("1. Programación");
        System.out.println("2. Fisica");
        System.out.println("3. Matematicas");
        System.out.print("Ingrese el indice de la categoria del seminario que desea ingresar: ");
        indice = sc.nextInt();
        sc.nextLine();

        switch (indice) {
            case 1:
                System.out.print("Ingrese nombre de la materia: ");
                name = sc.nextLine();
                for (CourseInformation c : courses_programacion) {
                    if(name.equals(c.getCourse_name())){
                        courseInformation=c;
                        return courseInformation;
                    }
                }
                if(courseInformation==null){
                    System.out.println("No se encontro un seminario con ese nombre");
                    return null;
                }
            
            case 2:
                System.out.println("Ingrese nombre de la materia: ");
                name = sc.nextLine();
                for (CourseInformation c : courses_fisica) {
                    if(name.equals(c.getCourse_name())){
                        courseInformation=c;
                        return courseInformation;
                    }
                }
                if(courseInformation==null){
                    System.out.println("No se encontro un seminario con ese nombre");
                    return null;
                }
            case 3:
                System.out.println("Ingrese nombre de la materia: ");
                name = sc.nextLine();
                for (CourseInformation c : courses_matematicas) {
                    if(name.equals(c.getCourse_name())){
                        courseInformation=c;
                        return courseInformation;
                    }
                }
                if(courseInformation==null){
                    System.out.println("No se encontro un seminario con ese nombre");
                    return null;
                }

            default:
                System.out.println("Opcion incorrecta");
                break;
        }

        return null;
    }
}