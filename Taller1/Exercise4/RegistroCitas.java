import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Date;

public class RegistroCitas {
    static ArrayList<Paciente> lista_pacientes = new ArrayList<>();
    static ArrayList<Medico> lista_medicos = new ArrayList<>();
    static ArrayList<Especialidad> lista_especialidad = new ArrayList<>();
    static ArrayList<Cita> lista_citas = new ArrayList<>();
    static ArrayList<Cita> citasFiltradas = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    /* Leer Archivo txt (Pacientes) */
    public static void leerArchivoTxt() {
        try (BufferedReader reader = new BufferedReader(new FileReader("lista_pacientes.txt"))) {
            String linea = "";
            while ((linea = reader.readLine()) != null) {
                String[] bloques = linea.split(",");
                if (bloques.length == 4) {
                    String nombre = bloques[0];
                    String cedula = bloques[1];
                    String telefono = bloques[2];
                    String direccion = bloques[3];

                    lista_pacientes.add(new Paciente(nombre, cedula, telefono, direccion));
                }
            }
        } catch (IOException e) {
            System.out.print("Error al leer el archivo: " + e.getMessage());
        }
    }

    /* Leer Archivo txt 2 (Medicos-Especialidad) */
    public static void leerArchivoTxt2() {
        try (BufferedReader reader = new BufferedReader(new FileReader("lista_medicos.txt"))) {
            String linea = "";
            while ((linea = reader.readLine()) != null) {
                String[] bloques = linea.split(",");
                if (bloques.length == 4) {
                    String nombre = bloques[0];
                    String name_espec = bloques[1];
                    String des_espec = bloques[2];
                    Especialidad especialidad = new Especialidad(name_espec, des_espec);
                    String codigo = bloques[3];

                    lista_medicos.add(new Medico(nombre, especialidad, codigo));
                    lista_especialidad.add(especialidad);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /* REGISTROS */
    /* registrarPaciente */
    public static void registrarPaciente(Paciente paciente) {
        lista_pacientes.add(paciente);
        System.out.println("Paciente añadido al registro");
    }

    /* registrarMedico */
    public static void registrarMedico(Medico medico) {
        lista_medicos.add(medico);
        System.out.println("Médico añadido al registro");
    }

    /* registrarEspecialidad */
    public static void registrarEspecialidad(Especialidad especialidad) {
        lista_especialidad.add(especialidad);
    }

    /* registrarCita */
    public static void registrarCita(Cita cita) {
        int fecha1 = 0, c = 0;
        Double hora1 = 0.0, hora2 = 0.0;
        boolean verificador = true;
        String horaS1 = "", horaS2 = "";

        for (int i = 0; i < lista_citas.size(); i++) {
            if (cita.getMedico().getNombre().equals(lista_citas.get(i).getMedico().getNombre())) {
                fecha1 = cita.getFechacCita().compareTo(lista_citas.get(i).getFechacCita());
                if (fecha1 == 0) {
                    horaS1 = cita.getHoraCita();
                    horaS2 = lista_citas.get(i).getHoraCita();
                    hora1 = Double.parseDouble(horaS1);
                    hora2 = Double.parseDouble(horaS2);
                    if (hora1 < hora2 + 1 && hora1 < hora2 - 1) {
                        System.out.println("El medico no esta disponible a esa hora");
                        verificador = false;
                        break;
                    }
                }
            }
        }

        if (verificador = true) {
            String estado_new = "Confirmada";
            cita.setEstado(estado_new);
            lista_citas.add(cita);
            System.out.println("Cita añadida al registro");
        }
        if (verificador = false) {
            System.out.println("Cita no añadida. Volviendo al menú principal");
        }
    }

    /* LISTAR */
    /* listarPacientes */
    public static void listarPacientes() {
        for (Paciente paciente : lista_pacientes) {
            System.out.println(paciente);
        }
    }

    /* listarMedicos */
    public static void listarMedicos() {
        for (Medico medico : lista_medicos) {
            System.out.println(medico);
        }
    }

    /* listarEspecialidad */
    public static void listarEspecialidad() {
        HashSet<String> nombresUnicos = new HashSet<>();

        for (Especialidad especialidad : lista_especialidad) {
            if (!nombresUnicos.contains(especialidad.getNombre())) {
                System.out.println(especialidad);
                nombresUnicos.add(especialidad.getNombre());
            }
        }
    }

    /* listarCita */
    public static void listarCita() {
        for (Cita cita : lista_citas) {
            System.out.println(cita);
        }
    }

    /* BUSCAR CITAS */
    public static ArrayList<Cita> filtrarCitas(String filtro) {

        for (Cita cita : lista_citas) {
            if (cita.getPaciente().getNombre().equalsIgnoreCase(filtro) ||
                    cita.getMedico().getNombre().equalsIgnoreCase(filtro) ||
                    cita.getMedico().getEspecialidad().getNombre().equalsIgnoreCase(filtro) ||
                    cita.getFechacCita().toString().equalsIgnoreCase(filtro)) {
                citasFiltradas.add(cita);
            }
        }

        return citasFiltradas;
    }

    public static void listarFiltro() {
        for (Cita contador : citasFiltradas) {
            System.out.println(contador);
        }
    }

    /* MÉTODOS EXTERNOS */
    // Estos metodos acortan el codigo en cuanto a lo que se ve en el metodo
    // menuPrincipal y mejoran la organización
    public static Paciente crearPaciente() {
        String nombre = "", cedula = "", telefono = "", direccion = "";

        System.out.print("Ingrese el nombre del paciente: ");
        nombre = sc.nextLine();

        System.out.print("Ingrese la cedula del paciente: ");
        cedula = sc.nextLine();

        System.out.print("Ingrese el telefono del paciente: ");
        telefono = sc.nextLine();

        System.out.print("Ingrese la direccion del paciente: ");
        direccion = sc.nextLine();

        Paciente paciente = new Paciente(nombre, cedula, telefono, direccion);
        return paciente;
    }

    public static Medico crearMedico() {
        String nombre = "", especialidad_nombre = "", especialidad_descripcion = "", codigo = "";
        boolean verificador = true;

        System.out.print("Ingrese el nombre del medico: ");
        nombre = sc.nextLine();

        System.out.print("Ingrese la especialidad del medico: ");
        especialidad_nombre = sc.nextLine();

        System.out.print("Ingrese la descripción de la especialidad: ");
        especialidad_descripcion = sc.nextLine();

        System.out.print("Ingrese el codigo del medico: ");
        codigo = sc.nextLine();

        Especialidad especialidad = new Especialidad(especialidad_nombre, especialidad_descripcion);

        for (int i = 0; i < lista_especialidad.size(); i++) {
            if (especialidad_nombre.equals(lista_especialidad.get(i).getNombre())) {
                verificador = true;
                break;
            }
        }

        if (verificador = false) {
            lista_especialidad.add(especialidad);
        }

        Medico medico = new Medico(nombre, especialidad, codigo);
        return medico;
    }

    public static Especialidad crearEspecialidad() {
        String nombre = "", descripcion = "";
        System.out.print("Ingrese la especialidad: ");
        nombre = sc.nextLine();
        System.out.print("Ingrese la descripcion:");
        descripcion = sc.nextLine();

        Especialidad especialidad = new Especialidad(nombre, descripcion);
        return especialidad;
    }

    public static Cita crearCita() {
        int opcion4 = 0;
        String cedula = "", codigo = "", hora = "", estado = "pendiente";
        Paciente paciente = null;
        Medico medico = null;
        Date fecha;

        System.out.println("El paciente ya esta ingresado en el registro");
        System.out.println("1. Si");
        System.out.println("2. No");
        System.out.print("Ingrese la opción: ");
        opcion4 = sc.nextInt();
        sc.nextLine();

        if (opcion4 == 1) {
            System.out.print("Ingrese la cedula del paciente: ");
            cedula = sc.nextLine();
            for (int i = 0; i < lista_pacientes.size(); i++) {
                if (cedula.equals(lista_pacientes.get(i).getCedula())) {
                    paciente = lista_pacientes.get(i);
                    break;
                }
            }
        } else if (opcion4 == 2) {
            paciente = crearPaciente();
            registrarPaciente(paciente);
        } else {
            System.out.println("Opción incorrecta. Volviendo al menú");
            return null;
        }

        listarMedicos();
        System.out.print("Ingrese el codigo del medico: ");
        codigo = sc.nextLine();

        for (int i = 0; i < lista_medicos.size(); i++) {
            if (codigo.equals(lista_medicos.get(i).getCodigoMedico())) {
                medico = lista_medicos.get(i);
                break;
            }
        }

        System.out.println("Ingrese la fecha de la cita");
        fecha = crearFecha();

        System.out.print("Ingrese la hora de la cita usando punto para separar hora de minutos(Por ejemplo, 6.30)");
        hora = sc.nextLine();
        sc.nextLine();

        System.out.println(
                "Por ahora, el estado de la cita es ´PENDIENTE´, verificaremos en el sistema si hay disponibilidad y cambiaremos su estado");

        Cita cita = new Cita(paciente, medico, fecha, hora, estado);
        return cita;
    }

    /* crearFecha */
    public static Date crearFecha() {
        int dia = 0, mes = 0, anio = 0;
        System.out.println("Ingrese el dia: ");
        dia = sc.nextInt();

        System.out.println("Ingrese mes: ");
        mes = sc.nextInt();
        mes--;

        System.out.println("Ingrese año: ");
        anio = sc.nextInt();
        anio -= 1990;

        Date fecha = new Date(anio, mes, dia);
        return fecha;
    }

    public static String filtro() {
        String filtro = "";
        System.out.println("Ingrese el filtro para buscar citas (nombre del paciente, médico, especialidad o fecha):");
        filtro = sc.nextLine();

        return filtro;
    }

    /* Menú Principal */
    public static void menuPrincipal() {
        int opcion = 0, opcion2 = 0;

        do {
            System.out.println("1. Registros");
            System.out.println("2. Listar");
            System.out.println("3. Buscar");
            System.out.println("4. Salir del programa");
            System.out.print("Ingrese el indice de la opción que desea: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    Paciente paciente;
                    Medico medico;
                    Especialidad especialidad;
                    Cita cita;
                    String filtro = "";
                    System.out.println("REGISTROS");
                    System.out.println("1. Registrar paciente");
                    System.out.println("2. Registrar un medico");
                    System.out.println("3. Registrar una especialidad");
                    System.out.println("4. Registrar una cita");
                    System.out.println("5. Salir al menú principal");
                    System.out.print("Ingrese el indice de la opción que desea: ");
                    opcion2 = sc.nextInt();
                    sc.nextLine();

                    switch (opcion2) {
                        case 1:
                            paciente = crearPaciente();
                            registrarPaciente(paciente);
                            break;

                        case 2:
                            medico = crearMedico();
                            registrarMedico(medico);
                            break;

                        case 3:
                            especialidad = crearEspecialidad();
                            registrarEspecialidad(especialidad);
                            break;

                        case 4:
                            cita = crearCita();
                            registrarCita(cita);
                            break;

                        case 5:
                            break;

                        default:
                            System.out.println("Opción incorrecta. Volviendo al menú principal");

                    }
                    break;

                case 2:
                    System.out.println("LISTAR");
                    System.out.println("1. Listar pacientes");
                    System.out.println("2. Listar medicos");
                    System.out.println("3. Listar especialidad");
                    System.out.println("4. Listar citas");
                    System.out.println("5. Salir al menú principal");
                    System.out.print("Ingrese el indice de la opción que desea: ");
                    opcion2 = sc.nextInt();
                    sc.nextLine();

                    switch (opcion2) {
                        case 1:
                            listarPacientes();
                            break;

                        case 2:
                            listarMedicos();
                            break;

                        case 3:
                            listarEspecialidad();
                            break;

                        case 4:
                            listarCita();
                            break;

                        case 5:
                            break;
                    }
                    break;

                case 3:
                    filtro = filtro();
                    filtrarCitas(filtro);
                    listarFiltro();
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Opción incorrecta. Volviendo al menú principal");
            }
        } while (opcion != 4);
    }
}
