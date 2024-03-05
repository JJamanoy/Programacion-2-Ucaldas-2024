import java.util.ArrayList;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList arraylist = new ArrayList();

        System.out.print("Pulsa 1 si quieres agregar un elemento");
        System.out.println();
        System.out.print("Pulsa 2 si quieres quitar un elemento");
        System.out.print("¿Que deseas hacer? ");
        int opcion = input.nextInt();

        if (opcion == 1) {
            System.out.print("Que elemento desea agregar: ");
            String elemento_agregar = input.nextLine();

        }

    }
}