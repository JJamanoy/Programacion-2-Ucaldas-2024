import java.util.ArrayList;

public class Teacher extends Person{

    private String teacher_id="";
    private ArrayList <Subject> materias = new ArrayList<>();
    private ArrayList <String> salones = new ArrayList<>();

    public Teacher(String user_name, String last_name, String document, String gender, String teacher_id){
        super(user_name, last_name, document, gender);
        this.teacher_id = teacher_id;

    }

    public void addMaterias(String name, String hours){
        materias.add(new Subject(name, hours));
    }

    public void listarArraySubject(){
        for (Subject a: materias){
            System.out.println(a.toString());
        }
    }

    public void listarArrayClassrom(){
        for (String a: salones){
            System.out.println(a);
        }
    }

    public void addSalones(String name){
        salones.add(name);
    }


    @Override
    public String toString() {
        return super.toString() + " Teacher id: " + teacher_id;
    }
}
