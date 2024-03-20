import java.util.ArrayList;
import java.util.Scanner;

public class tareas {
    public ArrayList<tareas_constructor> tareas = new ArrayList<tareas_constructor>();
    Scanner input = new Scanner(System.in);

    public void input() {

        System.out.print("Cuantas tareas quiere ingresar: ");
        int task_num = input.nextInt();

        for (int i = 0; i < task_num; i++) {
            System.out.print("Ingrese la tarea: ");
            String name_task = input.nextLine();
            input.nextLine();

            System.out.print("Ingrese la duración de la tarea en minutos: ");
            int time = input.nextInt();

            System.out.print("Ingrese el nombre de la persona encargada: ");
            String person_resposible = input.nextLine();
            input.nextLine();

            System.out.println("Ingrese el estado en que se encuentra la tarea");
            System.out.println("Pulse 1 si la tarea esta activa.");
            System.out.println("Pulse 2 si la tarea esta en desarollo.");
            System.out.println("Pulse 3 si la tarea esta realizada.");
            String status = input.nextLine();

            tareas.add(new tareas_constructor(name_task, person_resposible, time, time));
            System.out.println("Tarea Registrada.");
            System.out.println("LISTA DE TAREAS");
            System.out.println(tareas);
        }
    }
}