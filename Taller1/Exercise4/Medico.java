public class Medico {
    String nombre = "";
    Especialidad especialidad;
    String codigoMedico = "";

    public Medico(String nombre, Especialidad especialidad, String codigoMedico) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.codigoMedico = codigoMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public String getCodigoMedico() {
        return codigoMedico;
    }

    public void setCodigoMedico(String codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    @Override
    public String toString() {
        return "Medico:" + nombre + "   " + especialidad + "   Codigo del medico:" + codigoMedico;
    }

}