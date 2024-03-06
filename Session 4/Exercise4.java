import java.util.ArrayList;
import java.util.Scanner;

class Contacto {
    private String nombre_contacto;
    private String telefono_contacto;
    private String email_contacto;

    public Contacto(String nombre_contacto, String telefono_contacto, String email_contacto) {
        this.nombre_contacto = nombre_contacto;
        this.telefono_contacto = telefono_contacto;
        this.email_contacto = email_contacto;
    }

    public String getNombre_contacto() {
        return nombre_contacto;
    }

    public String getTelefono_contacto() {
        return telefono_contacto;
    }

    public String getEmail_contacto() {
        return email_contacto;
    }

    public void setTelefono_contacto(String telefono) {
        this.telefono_contacto = telefono_contacto;
    }

    public void setEmail_contacto(String email) {
        this.email_contacto = email_contacto;
    }

    public String toString() {
        return "Nombre: " + nombre_contacto + ", Teléfono: " + telefono_contacto + ", Email: " + email_contacto;
    }

}

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arraylist = new ArrayList<String>();

    }
}
