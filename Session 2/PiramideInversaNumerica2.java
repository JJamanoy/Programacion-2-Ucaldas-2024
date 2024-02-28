import java.util.Scanner;

public class PiramideInversaNumerica2 {
    public static void main(String[] args) {

        // Variables que se van a usar
        Scanner input = new Scanner(System.in);
        int espacios = 0;
        int c = 1;

        // Se le pide al usuario un número
        System.out.print("Ingrese hasta que número desea la piramide: ");
        int n = input.nextInt();

        /* Este ciclo definira las filas que tendra la piramide */
        for (int i = 0; i < n; i++) {
            // Se añaden espacios a cada linea
            for (int j = 0; j < espacios; j++) {
                System.out.print(" ");
            }
            // Se escriben los números en cada fila
            for (int k = c; k <= n; k++) {
                System.out.print(k + " ");
            }
            // Se aplica un salto de linea, se agrega un espacio para la siguiente fila y
            // se le suma 1 a "c" para que empiece la siguiente fila desde ese nuevo número
            System.out.println();
            espacios++;
            c++;
        }
    }
}
