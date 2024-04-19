public class CourseInformation {
    private String course_name="";
    private int week_hours=0;
    private Professor proffesor_info;

    public CourseInformation(String course_name, int week_hours, Professor proffesor_info) {
        this.course_name = course_name;
        this.week_hours = week_hours;
        this.proffesor_info = proffesor_info;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getWeek_hours() {
        return week_hours;
    }

    public void setWeek_hours(int week_hours) {
        this.week_hours = week_hours;
    }

    public Professor getProffesor_info() {
        return proffesor_info;
    }

    public void setProffesor_info(Professor proffesor_info) {
        this.proffesor_info = proffesor_info;
    }

    @Override
    public String toString() {
        return "Name Course: " + course_name + " Week Hours: " + week_hours + " Informaciòn: "
                + proffesor_info;
    }

    
}
