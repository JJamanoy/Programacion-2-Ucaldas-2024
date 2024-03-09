public class Main {

    static tareas instance_tareas = new tareas();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            instance_tareas.input();
        }
    }
}