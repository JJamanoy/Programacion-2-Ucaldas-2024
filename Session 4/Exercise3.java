import java.util.LinkedList;
import java.util.Scanner;;

public class Exercise3 {
    public static void main(String[] args) {

        LinkedList<String> linkedlist = new LinkedList<>();
        Scanner input = new Scanner(System.in);

        linkedlist.add("500");
        linkedlist.add("400");
        linkedlist.add("300");
        linkedlist.add("200");
        linkedlist.add("100");

        System.out.println("Del 0 al 4, mencione que elemento desea ver: ");
        int indice = input.nextInt();

        String elemento = linkedlist.get(indice);

        System.out.println("El elemento de la posición " + indice + "es: " + elemento);

    }
}