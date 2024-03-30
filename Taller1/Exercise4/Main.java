public class Main {
    static RegistroCitas instance_RegistroCitas = new RegistroCitas();

    public static void main(String[] args) {
        instance_RegistroCitas.leerArchivoTxt();
        instance_RegistroCitas.leerArchivoTxt2();
        instance_RegistroCitas.menuPrincipal();
    }
}
