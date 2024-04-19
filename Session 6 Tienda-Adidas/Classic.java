import java.util.ArrayList;
import java.util.Scanner;

public class Classic {
    /* NOMBRAR VARIABLES */
    ArrayList<Shoes> running_shoes = new ArrayList<>();
    ArrayList<Shoes> tennis_colours = new ArrayList<>();
    ArrayList<Shoes> tennis_price = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    /* addClassicShoes */
    // Se añaden los elementos al arraylist runing_shoes
    public ArrayList<Shoes> addClassicShoes() {
        running_shoes.add(new Shoes("23434", 100f, 38, "ruta1", false, 15));
        running_shoes.add(new Shoes("132434", 200f, 39, "ruta2", true, 3));
        running_shoes.add(new Shoes("043434", 150f, 43, "ruta3", false, 2));
        running_shoes.add(new Shoes("2439344", 250f, 44, "ruta4", true, 10));
        return running_shoes;
    }

    /* showInformationShoes */
    // Este método imprime los elementos del arraylist running_shoes
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

    /* EJERCICIO 2 */
    /* */
    /* */
    /* */
    /* */
    /* tennis_colour_comprobation */
    // Este método devuelve un arraylist donde estan todos los tenis que tengan el
    // mismo o más cantidad de colores
    public ArrayList<Shoes> tennis_colour_comprobation() {
        int num_colours = 0;
        System.out.print("Escribe el número de colores minimo que desea para sus tenis: ");
        num_colours = input.nextInt();
        for (int i = 0; i < running_shoes.size(); i++) {
            if (running_shoes.get(i).getcant_colours() >= num_colours) {
                tennis_colours.add(running_shoes.get(i));
            }
        }

        return tennis_colours;
    }

    /* showInformationTennisColours */
    // Esta función imprime los elementos del arraylist tennis_colours_5
    public void showInformationTennisColours() {
        for (int i = 0; i < tennis_colours.size(); i++) {
            System.out.println(tennis_colours.get(i).getReference() + "- Talla: " +
                    tennis_colours.get(i).getsize() + " - Precio: " +
                    tennis_colours.get(i).getPrice() + "- Fotos: " +
                    tennis_colours.get(i).getphoto_route() + "- Envio a casa: " +
                    tennis_colours.get(i).isSend_method() + "- Cantidad de colores: " +
                    tennis_colours.get(i).getcant_colours());
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
}
