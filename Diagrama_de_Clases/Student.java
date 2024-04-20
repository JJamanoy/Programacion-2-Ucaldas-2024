import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person{

    public String Student_number="";
    public float Average_mark=0.0f;
    Seminars instance_Seminars= new Seminars();
    Scanner sc = new Scanner (System.in);
    CourseInformation course;
    ArrayList<CourseInformation> Seminars_suscribed = new ArrayList<>();

    public Student(String name, String phone_number, String email_address, String Student_number, float Average_mark) {
        super(name, phone_number, email_address);
        this.Student_number = Student_number;
        this.Average_mark = Average_mark;
    }

    public String getStudent_number() {
        return Student_number;
    }

    public void setStudent_number(String student_number) {
        Student_number = student_number;
    }

    public float getAverage_mark() {
        return Average_mark;
    }

    public void setAverage_mark(float average_mark) {
        Average_mark = average_mark;
    }

    public void leerArchivosTxt(){
        instance_Seminars.leerArchivoTxtFis();
        instance_Seminars.leerArchivoTxtMat();
        instance_Seminars.leerArchivoTxtProg();
    }

    public void IsEligibleToEnroll(){
        int opcion=0;
        System.out.print("MENU \n1. Listar\n2. Añadir una nueva asignatura a su registro\n Su opción: ");
        opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                int opcion1=0;
                System.out.print("De que materia desea ver el registro:\n1. Programación\n2. Fisica\n3. Matematicas\nIngrese el indice: ");
                opcion1 = sc.nextInt();
                sc.nextLine();
        
                switch (opcion1) {
                    case 1:
                        instance_Seminars.watchSeminarProg();
                        System.out.println();
                        break;
                    case 2:
                        instance_Seminars.watchSeminarFis();
                        System.out.println();
                        break;
                    case 3:
                        instance_Seminars.watchSeminarMat();
                        System.out.println();
                        break;
                    default:
                        break;
                }
                break; 
            
            case 2:
                course = instance_Seminars.course_info();
                Seminars_suscribed.add(course);
                System.out.println("Materia Inscrita");
                break;
            default:
                break;
        }

    }

    public void GetSeminarsTaken(){
        for (CourseInformation courseInformation : Seminars_suscribed) {
            System.out.println(courseInformation);
        }
    }

    public void Menu(){
        int opcion_final=0;
        do{
            System.out.println("Pulse 1 si desea ver las materias totales o insrcibir una (IsEligibleToEnroll)");
            System.out.println("Pulse 2 si desea ver las materias que el estudiante inscribio (GetSeminarsTaken)");
            System.out.println("Pulse 3 para salir");
            System.out.print("Su opción: ");
            opcion_final = sc.nextInt();
            sc.nextLine();

            switch (opcion_final) {
                case 1:
                    IsEligibleToEnroll();
                    break;
            
                case 2:
                    GetSeminarsTaken();
                    break;
                
                case 3:
                    break;

                default:
                    System.out.println("Opción Incorrecta. Volviendo al menú");
                    break;
            }

        }while(opcion_final!=3);
    }

}
