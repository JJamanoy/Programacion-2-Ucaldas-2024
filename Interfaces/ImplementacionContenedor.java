import java.util.ArrayList;

public class ImplementacionContenedor implements Contenedor{

    public ArrayList<Estudiante> ListaEstudiantes = new ArrayList<>();

    public ImplementacionContenedor(){
        this.ListaEstudiantes.add(new Estudiante("Miguel","0908"));
        this.ListaEstudiantes.add(new Estudiante("Luisa", "5678"));
        this.ListaEstudiantes.add(new Estudiante("Angel", "1234"));
    }

    public ArrayList<Estudiante> obtenerEstudiantes() {
        return this.ListaEstudiantes;
    }
    
}
