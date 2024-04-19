public class Main {
    static RegistroEstudiante instance_registro = new RegistroEstudiante();

    public static void main(String[] args) {

        instance_registro.leerArchivoTxt();
        instance_registro.menuEstudiantes();

    }

}