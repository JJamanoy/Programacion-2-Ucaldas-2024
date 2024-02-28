import java.util.Scanner;

public class AdivinarNumero {
    public static void main(String[] args) {
        // Variables que se van a usar
        Scanner input = new Scanner(System.in);
        int random;

        // Se crea el número aleatorio de 0 a 100
        random = (int) (Math.random() * (100 + 1));

        // Se le solicita al usuario que ingrese un número
        System.out.print("Dime un número del 1 al 100 para jugar: ");
        int n = input.nextInt();

        /* Mientras el usuario no acierte el número, se repetirá el ciclo */
        while (n != random) {
            // Si el número es inferior o mayor al número aleatorio, se le comunica al
            // usuario
            if (n < random) {
                System.out.println("El número es inferior al que hay que adivinar, diga uno más alto");
            } else {
                System.out.println("El número es mayor al que hay que adivinar, diga uno más bajo");
            }

            // Se le pide nuevamente al usuario un número
            System.out.print("Escribe un número del 1 al 100: ");
            int r = input.nextInt();
            n = r;
        }

        System.out.println("Felicidades, has adivinado el número");
    }
}
