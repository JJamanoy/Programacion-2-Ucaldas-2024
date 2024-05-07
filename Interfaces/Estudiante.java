public class Estudiante {
    private String student_name = "";
    private String student_Code = "";

    public Estudiante(String student_name, String student_Code) {
        this.student_name = student_name;
        this.student_Code = student_Code;
    }

    public String getStudent_name() {
        return student_name;
    }

    public String getStudent_Code() {
        return student_Code;
    }   

}
