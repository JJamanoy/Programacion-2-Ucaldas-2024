import java.util.ArrayList;
import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {

        /* VARIABLES */
        Scanner input = new Scanner(System.in);
        int option;
        Exercise4 objeto = new Exercise4();
        ArrayList<String> nombres_contactos = new ArrayList<>();
        ArrayList<String> numero_contactos = new ArrayList<>();
        ArrayList<String> correo_contactos = new ArrayList<>();

        /* INICIO CODIGO */
        do {
            System.out.println("           Menú   ");
            System.out.println("1. Agregar un nuevo contacto");
            System.out.println("2. Eliminar un contacto existente");
            System.out.println("3. Buscar un contacto");
            System.out.println("4. Mostrar lista de todos los contactos");
            System.out.println("5. Actualizar información de un contacto");
            System.out.println("6. Salir del programa");
            System.out.print("Seleccione una opción: ");
            option = input.nextInt();

            switch (option) {
                case 1:
                    String nombre_contacto_nuevo = objeto.nombre_contacto_nuevo();
                    String numero_contacto_nuevo = objeto.numero_contacto_nuevo();
                    String correo_contacto_nuevo = objeto.correo_contacto_nuevo();

                    nombres_contactos.add(nombre_contacto_nuevo);
                    numero_contactos.add(numero_contacto_nuevo);
                    correo_contactos.add(correo_contacto_nuevo);

                    System.out.println("Contacto Añadido");
                    System.out.println();
                    break;
                case 2:
                    lista_contactos(nombres_contactos, numero_contactos, correo_contactos);
                    int num_eliminar = objeto.num_eliminar_contacto();
                    num_eliminar--;

                    nombres_contactos.remove(num_eliminar);
                    numero_contactos.remove(num_eliminar);
                    correo_contactos.remove(num_eliminar);
                    break;
                case 3:
                    int indice_nombre_buscar = objeto.indice_nombre_buscar(nombres_contactos);
                    System.out.print("El contacto encontrado es: ");
                    System.out.print(nombres_contactos.get(indice_nombre_buscar) + " | "
                            + numero_contactos.get(indice_nombre_buscar) + " | "
                            + correo_contactos.get(indice_nombre_buscar));
                    System.out.println();
                    break;

                case 4:
                    lista_contactos(nombres_contactos, numero_contactos, correo_contactos);
                    break;

                case 5:
                    int contacto_actualizar = objeto.contacto_actualizar(nombres_contactos);
                    int parametro_a_cambiar = objeto.parametro_a_cambiar();
                    String nuevo_cambio = objeto.nuevo_cambio(parametro_a_cambiar);

                    switch (parametro_a_cambiar) {
                        case 1:
                            nombres_contactos.set(contacto_actualizar, nuevo_cambio);
                            break;
                        case 2:
                            numero_contactos.set(contacto_actualizar, nuevo_cambio);
                            break;
                        case 3:
                            correo_contactos.set(contacto_actualizar, nuevo_cambio);
                            break;
                    }

                    System.out.println("Cambio establecido.");
                    break;

                case 6:
                    System.out.println("Fin del programa. Buen dia!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 6);
    }

    /* OPCIÓN 1 */
    // Para guardar los contactos nuevos
    public String nombre_contacto_nuevo() {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese el nombre del contacto: ");
        String nombre_contacto_nuevo = input.nextLine();

        return nombre_contacto_nuevo;
    }

    public String numero_contacto_nuevo() {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese el número del contacto: ");
        String numero_contacto_nuevo = input.nextLine();

        return numero_contacto_nuevo;
    }

    public String correo_contacto_nuevo() {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese el correo del contacto: ");
        String correo_contacto_nuevo = input.nextLine();

        return correo_contacto_nuevo;
    }

    /* OPCIÓN 2 */
    // Eliminar conctacto
    public int num_eliminar_contacto() {
        Scanner input = new Scanner(System.in);
        System.out.print("Diga el indice del contacto al que desea eliminar: ");
        int num_eliminar_contacto = input.nextInt();

        return num_eliminar_contacto;
    }

    /* OPCIÓN 3 */
    // Buscar contacto
    public int indice_nombre_buscar(ArrayList<String> nombres_contactos) {
        Scanner input = new Scanner(System.in);
        int indice_nombre_buscar = 0;
        String nombre, nombre_min;

        System.out.print("Escribe el nombre exacto del contacto guardado que deseas buscar: ");
        String nombre_buscar = input.nextLine();

        String nombre_buscar_min = nombre_buscar.toLowerCase();

        do {
            nombre = nombres_contactos.get(indice_nombre_buscar);
            nombre_min = nombre.toLowerCase();
            indice_nombre_buscar++;
        } while (!nombre_min.equals(nombre_buscar_min) && indice_nombre_buscar < nombres_contactos.size());

        indice_nombre_buscar--;

        return indice_nombre_buscar;

    }

    /* OPCIÓN 4 */
    // Muestra la lista de los contactos
    public static void lista_contactos(ArrayList<String> nombres_contactos, ArrayList<String> numero_contactos,
            ArrayList<String> correo_contactos) {
        int tamaño_contactos = nombres_contactos.size();

        for (int i = 0; i < tamaño_contactos; i++) {
            System.out.print((i + 1) + ". " + nombres_contactos.get(i) + " | " + numero_contactos.get(i) + " | "
                    + correo_contactos.get(i));
            System.out.println();
        }
        System.out.println();
    }

    /* OPCIÓN 5 */
    // Modificar contacto
    public int contacto_actualizar(ArrayList<String> nombres_contactos) {
        Scanner input = new Scanner(System.in);
        int indice_nombre_buscar = 0;
        String nombre, nombre_min;

        System.out.print("Escribe el nombre exacto del contacto guardado que deseas modificar: ");
        String nombre_buscar = input.nextLine();

        String nombre_buscar_min = nombre_buscar.toLowerCase();

        do {
            nombre = nombres_contactos.get(indice_nombre_buscar);
            nombre_min = nombre.toLowerCase();
            indice_nombre_buscar++;
        } while (!nombre_min.equals(nombre_buscar_min) && indice_nombre_buscar < nombres_contactos.size());

        indice_nombre_buscar--;

        return indice_nombre_buscar;

    }

    public int parametro_a_cambiar() {

        Scanner input = new Scanner(System.in);
        System.out.println("Pulse 1 si desea cambiar el nombre del contacto.");
        System.out.println("Pulse 2 si desea cambiar el telefono del contacto.");
        System.out.println("Pulse 3 si desea cambiar el correo del contacto.");
        System.out.print("¿Que parametro desea cambiar? ");
        int parametro_a_cambiar = input.nextInt();

        return parametro_a_cambiar;
    }

    public String nuevo_cambio(int parametro_a_cambiar) {
        Scanner input = new Scanner(System.in);
        String nuevo_cambio = "";
        switch (parametro_a_cambiar) {
            case 1:
                System.out.print("Escriba el nuevo nombre del contacto:");
                nuevo_cambio = input.nextLine();
                break;

            case 2:
                System.out.print("Escriba el nuevo telefono del contacto: ");
                nuevo_cambio = input.nextLine();
                break;

            case 3:
                System.out.print("Escriba el nuevo correo del contacto: ");
                nuevo_cambio = input.nextLine();
                break;

            default:
                System.out.println("Escriba una opción valida. Intente de nuevo");
        }

        return nuevo_cambio;
    }
}