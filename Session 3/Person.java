import java.util.Scanner;

public class Person {

    Scanner input = new Scanner(System.in);

    public String name_person = "";
    public String address_person = "";
    public String email = "";

    public void inputDataUser() {
        System.out.println("Enter your name: ");
        name_person = input.nextLine();

        System.out.println("Enter your address: ");
        address_person = input.nextLine();

    }

}