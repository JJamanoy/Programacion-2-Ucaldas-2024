import java.util.Scanner;

public class WomanMenu {

    Scanner input = new Scanner(System.in);

    /* showMenu */
    // Este método imprime el menú de calzado, productos destacados, ropa,
    // accesorios y deportes
    public String showMenu() {
        return "    1. Calzado\n    2. Productos destacados\n    3. Ropa\n    4. Accesorios\n    5. Deportes\n";
    }

    /* option_menu */
    // Este método imprime el menú con sus funcionalidades
    public void option_menu() {
        // Imprime el menú
        System.out.println(showMenu());

        // Se nombran variables y se guarda la variable en option
        int option = 0;
        int option_submenu = 0;
        System.out.print("Ingrese el número de la sección: ");
        option = input.nextInt();

        // Este ciclo permite darle funcionalidades a cada categoria del menú superior
        switch (option) {
            case 1:
                // Submenú
                System.out.print("\n     CALZADO\n     1. Running\n     2. Classic\n     Selecciona una opción: ");
                option_submenu = input.nextInt();
                // Opción de Running
                if (option_submenu == 1) {
                    Running instance_running = new Running(); // Se nombra la estancia
                    instance_running.addRunningShoes(); // Se añaden los elementos
                    System.out.println(instance_running.showInformationShoes()); // Se muestran los elementos

                    System.out.println("-------------------------");

                    instance_running.tennis_size_comprobation(); // Se hace la comprobación de tallas
                    System.out.println("-----------------------");
                    System.out.println("Lista de tenis hallados");
                    instance_running.showInformationTennisSize(); // Se muestran los tenis que tengan esa talla

                    instance_running.tennis_price_comprobation();
                    System.out.println("-----------------------");
                    System.out.println("Lista de tenis hallados");
                    instance_running.showInformationTennisPrice();

                    instance_running.tennis_send_comprobation();
                    System.out.println("-----------------------");
                    System.out.println("Lista de tenis hallados");
                    instance_running.showInformationTennisSend();
                }

                // Opción de Classic
                else if (option_submenu == 2) {
                    Classic instance_classic = new Classic();
                    instance_classic.addClassicShoes();
                    System.out.println(instance_classic.showInformationShoes());

                    System.out.println("-------------------------");

                    instance_classic.tennis_colour_comprobation();
                    System.out.println("-------------------------");
                    System.out.println("Lista de tenis hallados");
                    instance_classic.showInformationTennisColours();

                    instance_classic.tennis_price_comprobation();
                    System.out.println("-----------------------");
                    System.out.println("Lista de tenis hallados");
                    instance_classic.showInformationTennisPrice();
                } else {
                    System.out.println("Opción no válida");
                }
                break;
            case 2:
                System.out.println("Productos destacados");
            case 3:
                System.out.println("Ropa");
            case 4:
                System.out.println("Accesorios");
            case 5:
                System.out.println("Deportes");
        }
    }
}
