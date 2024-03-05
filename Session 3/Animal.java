import java.util.Scanner;

public class Animal {

    Scanner input = new Scanner(System.in);

    public String raza_perro = "";
    public int peso_perro;
    public String nombre_perro = "";

    public void inputDataUser() {
        System.out.print("Ingrese la raza del perro: ");
        raza_perro = input.nextLine();

        System.out.print("Ingrese el peso del perro: ");
        peso_perro = input.nextInt();

        System.out.print("Ingrese el nombre del perro: ");
        nombre_perro = input.nextLine();
        input.nextLine();
    }
}