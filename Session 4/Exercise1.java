public class Exercise1 {
    public static void main(String[] args) {
        int[] array = { 1, 3, 20, 25, 42 };

        int suma = 0;

        for (int i = 0; i < array.length; i++) {
            suma = array[i] + suma;
        }

        System.out.println("El resultado de la suma de los elementos del arreglo es de " + suma);

    }
}