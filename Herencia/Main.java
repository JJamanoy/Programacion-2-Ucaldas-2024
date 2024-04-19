import java.util.ArrayList;

public class Main{

    static ArrayList <Teacher> profesores = new ArrayList<>();
    public static void main(String[] args) {
        Student student = new Student("Jacinto","Diaz","123456", "MASCULINO", "04304");
        System.out.println(student.toString());

        Teacher teacher1 = new Teacher("Jero", null, "123", null, null);
        profesores.add(teacher1);

        addmaterias("123","Calculo","3");
        System.out.println(teacher1.toString());
        teacher1.listarArrayClassrom();
        teacher1.listarArraySubject();


    }

    public static void addmaterias(String document, String name, String hours_week){
        for(Teacher a: profesores){
            if(a.getDocument().equals(document)){
                a.addMaterias(name, hours_week);
                break;
            }
        }
    }


}