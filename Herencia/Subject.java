public class Subject {
    
    private String name = "";
    private String hours_week = "";
    public Subject(String name, String hours_week) {
        this.name = name;
        this.hours_week = hours_week;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getHours_week() {
        return hours_week;
    }
    public void setHours_week(String hours_week) {
        this.hours_week = hours_week;
    }

    @Override
    public String toString() {
        return "Nombre materia: " + name + "\nHoras semana: "+ hours_week ;
    }

}
