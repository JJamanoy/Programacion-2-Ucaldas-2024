import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person{

    public String Student_number="";
    public float Average_mark=0.0f;
    Seminars instance_seminars = new Seminars();
    Scanner sc =new Scanner(System.in);
    ArrayList <CourseInformation> subjects_register = new ArrayList<>();

    public Student(String name, String phone_number, String email_address, String Student_number, float Average_mark) {
        super(name, phone_number, email_address);
        this.Student_number = Student_number;
        this.Average_mark = Average_mark;
    }

    public String IsElegibleToEnroll(){
        return super.name + this.Student_number + this.Average_mark;
    }

    public void GetSeminarsTaken(){
        int indice=0;
        instance_seminars.addSeminar();
        instance_seminars.watchSeminar();
        System.out.print("Ingrese el indice del seminario al que desea ingresar: ");
        indice = sc.nextInt();
        
        subjects_register.add(instance_seminars.courses.get(indice));
    }

    public void watchSeminarsSuscribed(){
        for (CourseInformation courseInformation : subjects_register) {
            System.out.println(courseInformation);
        }
    }

}
