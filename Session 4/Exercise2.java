import java.util.ArrayList;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {

        /* Variables */
        Scanner input = new Scanner(System.in);
        int c = 0;
        ArrayList<String> arraylist = new ArrayList<String>();

        /* INICIO CODIGO */
        System.out.print("Pulsa 1 si quieres agregar un elemento.");
        System.out.println();
        System.out.println("Pulsa 2 si quieres quitar un elemento.");
        System.out.println("Pulse un número mayor para ver su arreglo final.");
        System.out.print("¿Que deseas hacer? ");
        int opcion = input.nextInt();

        // Función que sirve de parámetro para saber que quiere hacer el usuario
        while (opcion <= 2) {

            // Opción 1
            if (opcion == 1) {
                // Pregunta al usuario que desea agregar
                System.out.print("Escriba el elemento desea agregar: ");
                input.nextLine();
                String elemento_agregar = input.nextLine();

                // Se agrega el elemento a la lista
                arraylist.add(c, elemento_agregar);

                // Muestra al usuario el arreglo temporal para facilidad del usuario por si
                // desea quitar un elemento
                System.out.print("Este es su arreglo momentaneo: ");
                int tamaño_array = arraylist.size();
                for (int i = 0; i < tamaño_array; i++) {
                    System.out.print(arraylist.get(i) + ", ");
                }
                System.out.println();
                System.out.println();

                // Pregunta al usuario que opción desea hacer
                System.out.print("Cambio realizado. ¿Que opción desea hacer? ");
                int opcion_tem = input.nextInt();
                opcion = opcion_tem;
                c++;
            }

            // Opción 2
            if (opcion == 2) {
                // Pregunta al usuario que elemento desea eliminar
                System.out.print("Que elemento desea quitar (Indique el indice): ");
                int indice_quitar = input.nextInt();

                // Se quita el elemento de la lista
                arraylist.remove(indice_quitar);

                // Muestra al usuario el arreglo temporal para facilidad del usuario por si
                // desea quitar un elemento
                System.out.print("Este es su arreglo momentaneo: ");
                int tamaño_array = arraylist.size();
                for (int i = 0; i < tamaño_array; i++) {
                    System.out.print(arraylist.get(i) + ", ");
                }
                System.out.println();
                System.out.println();

                System.out.print("Cambio realizado. ¿Que deseas hacer? ");
                int opcion_tem = input.nextInt();
                opcion = opcion_tem;
            }

        }

        // Convierte el arraylist en un array
        Object[] array = arraylist.toArray();

        // Se imprime el arreglo
        System.out.println("Este seria su arreglo: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + ", ");
        }
    }
}
