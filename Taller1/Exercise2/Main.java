public class Main {
    static RegistroBiblioteca instance_RegistroBiblioteca = new RegistroBiblioteca();

    public static void main(String[] args) {
        instance_RegistroBiblioteca.leerArchivoTxt();
        instance_RegistroBiblioteca.librosmayor();
        instance_RegistroBiblioteca.menuLibro();

    }
}
