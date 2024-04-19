import java.util.ArrayList;
import java.util.Scanner;

public class Running {

    /* NOMBRAR VARIABLES */
    ArrayList<Shoes> running_shoes = new ArrayList<>();
    ArrayList<Shoes> tennis_size = new ArrayList<>();
    ArrayList<Shoes> tennis_price = new ArrayList<>();
    ArrayList<Shoes> tennis_send = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    /* AddRunningShoes */
    // Este método permite añadir elementos al arraylist running_shoes
    public ArrayList<Shoes> addRunningShoes() {
        running_shoes.add(new Shoes("1234", 100f, 38, "ruta1", false, 15));
        running_shoes.add(new Shoes("1324", 200f, 38, "ruta2", true, 8));
        running_shoes.add(new Shoes("0434", 150f, 43, "ruta3", false, 9));
        running_shoes.add(new Shoes("2434", 250f, 44, "ruta4", true, 10));
        return running_shoes;
    }

    /* showInformationShoes */
    // Este método permite mostrar los elementos completos del arraylist
    // running_shoes
    public String showInformationShoes() {
        String Information = "";
        for (int i = 0; i < running_shoes.size(); i++) {
            Information += running_shoes.get(i).getReference() + "- Talla: " +
                    running_shoes.get(i).getsize() + " - Precio: " +
                    running_shoes.get(i).getPrice() + "- Fotos: " +
                    running_shoes.get(i).getphoto_route() + "- Envio a casa: " +
                    running_shoes.get(i).isSend_method() + "- Cantidad de colores: " +
                    running_shoes.get(i).getcant_colours() + "\n";
        }

        return Information;
    }

    /* SOLUCIÓN EJERCICIO 1 */
    /* */
    /* */
    /* */
    /* */
    /* lista_Tennis_comprobacion */
    // Este método permite crear un arreglo con los elementos que tengan la talla
    // indicada
    public ArrayList<Shoes> tennis_size_comprobation() {
        int opcion = 0;
        System.out.print("Escribe el número de talla que deseas buscar: ");
        opcion = input.nextInt();
        for (int i = 0; i < running_shoes.size(); i++) {
            if (running_shoes.get(i).getsize() == opcion) {
                tennis_size.add(running_shoes.get(i));
            }
        }

        return tennis_size;
    }

    /* showInformationTalla */
    // Esta función permite mostrar los elementos completos del arraylist
    // lista_tennis_talla
    public void showInformationTennisSize() {
        for (int i = 0; i < tennis_size.size(); i++) {
            System.out.println(tennis_size.get(i).getReference() + "- Talla: " +
                    tennis_size.get(i).getsize() + " - Precio: " +
                    tennis_size.get(i).getPrice() + "- Fotos: " +
                    tennis_size.get(i).getphoto_route() + "- Envio a casa: " +
                    tennis_size.get(i).isSend_method() + "- Cantidad de colores: " +
                    tennis_size.get(i).getcant_colours());
            System.out.println();
        }
    }

    /* EJERCICIO 3 */
    /* */
    /* */
    /* */
    /* */
    /* tennis_price_comprobation */
    // Este método devuelve un arraylist donde estan todos los tenis que tengan un
    // precio superior al que se pide
    public ArrayList<Shoes> tennis_price_comprobation() {
        int price = 0;
        System.out.print("Escribe el precio minimo que desea para sus tenis: ");
        price = input.nextInt();
        for (int i = 0; i < running_shoes.size(); i++) {
            if (running_shoes.get(i).getPrice() >= price) {
                tennis_price.add(running_shoes.get(i));
            }
        }

        return tennis_price;
    }

    /* showInformationTennisPrice */
    // Esta función imprime los elementos del arraylist tennis_price
    public void showInformationTennisPrice() {
        for (int i = 0; i < tennis_price.size(); i++) {
            System.out.println(tennis_price.get(i).getReference() + "- Talla: " +
                    tennis_price.get(i).getsize() + " - Precio: " +
                    tennis_price.get(i).getPrice() + "- Fotos: " +
                    tennis_price.get(i).getphoto_route() + "- Envio a casa: " +
                    tennis_price.get(i).isSend_method() + "- Cantidad de colores: " +
                    tennis_price.get(i).getcant_colours());
            System.out.println();
        }
    }

    /* EJERCICIO 4 */
    /* */
    /* */
    /* */
    /* */
    /* tennis_send_comprobation */
    // Este método devuelve un arraylist donde estan todos los tenis que se puedan
    // llevar a la casa o bien, deban ser recogidos en bodegas
    public ArrayList<Shoes> tennis_send_comprobation() {
        int opcion = 0;
        System.out.print("Escribe 1 si quieres que los tenis hasta tu casa\n");
        System.out.println("Escribe 2 si quieres venir por tus tenis a la bodega");
        opcion = input.nextInt();
        for (int i = 0; i < running_shoes.size(); i++) {
            if (opcion == 1) {
                if (running_shoes.get(i).isSend_method() == true) {
                    tennis_send.add(running_shoes.get(i));
                }
            } else if (opcion == 2) {
                if (running_shoes.get(i).isSend_method() == false) {
                    tennis_send.add(running_shoes.get(i));
                }
            } else {
                System.out.println("Opción no valida");
            }
        }

        return tennis_send;
    }

    /* showInformationTennisSend */
    // Esta función imprime los elementos del arraylist tennis_send
    public void showInformationTennisSend() {
        for (int i = 0; i < tennis_send.size(); i++) {
            System.out.println(tennis_send.get(i).getReference() + "- Talla: " +
                    tennis_send.get(i).getsize() + " - Precio: " +
                    tennis_send.get(i).getPrice() + "- Fotos: " +
                    tennis_send.get(i).getphoto_route() + "- Envio a casa: " +
                    tennis_send.get(i).isSend_method() + "- Cantidad de colores: " +
                    tennis_send.get(i).getcant_colours());
            System.out.println();
        }
    }
}
