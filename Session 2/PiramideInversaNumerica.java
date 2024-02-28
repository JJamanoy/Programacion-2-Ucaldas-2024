import java.util.Scanner;

public class PiramideInversaNumerica {
    public static void main(String[] args) {

        // Variables que se van a usar
        Scanner input = new Scanner(System.in);
        int espacio = 0;

        // Se le solicita al usuario que ingrese un número
        System.out.print("Ingrese hasta que número desea la piramide: ");
        int n = input.nextInt();

        // Esta variable hace que "c" sea las filas y "n" para los números de cada fila
        int c = n;

        /*
         * Este ciclo acabara cuando las j sea igual a c, es decir, cuando se alcancen
         * las filas
         */
        for (int j = 0; j < c; j++) {
            // Se añaden las filas a la linea
            for (int k = 0; k < espacio; k++) {
                System.out.print(" ");
            }
            // Se copian los números de cada fila
            for (int i = 1; i <= n; i++) {
                System.out.print(i + " ");
            }
            // Se actualizan las variables, se da el salto de linea y se suma para que haya
            // espacio en la siguiente fila
            n--;
            System.out.println();
            espacio++;
        }
    }
}
