import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        ImplementacionContenedor instancia = new ImplementacionContenedor();
        ArrayList<Estudiante> ListaEstudiantes = instancia.obtenerEstudiantes();
        for (Estudiante estudiante : ListaEstudiantes) {
            System.out.println("Nombre: " + estudiante.getStudent_name()+"    Codigo:"+estudiante.getStudent_Code());
        }
    }
}