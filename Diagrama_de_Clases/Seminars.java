import java.util.ArrayList;

public class Seminars{
    
    ArrayList <CourseInformation> courses = new ArrayList<>();

    public void addSeminar(){
        courses.add(new CourseInformation("Prog 1", 5, new Professor("Jero", "312", "jero@ucaldas.com")));
        courses.add(new CourseInformation("Prog 2", 4, new Professor("Juan", "3142", "juan@ucaldas.com")));
        courses.add(new CourseInformation("Soft 2", 2, new Professor("Pedro", "3133", "pedro@caldas.com")));
        courses.add(new CourseInformation("Soft 1", 3, new Professor("Maria", "312323",  "maria@ucaldas.com")));
        courses.add(new CourseInformation("Prog 3", 5, new Professor("Alberto", "31290584", "albertoo@ucaldas.com")));
    }

    public void watchSeminar(){
        int i=0;
        for (CourseInformation courseInformation : courses) {
            System.out.println(i+" "+courseInformation);
            i++;
        }
    }

    
}