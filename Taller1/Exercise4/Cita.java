import java.util.Date;

public class Cita {
    Paciente paciente;
    Medico medico;
    Date fechacCita;
    String HoraCita;
    String estado;

    public Cita(Paciente paciente, Medico medico, Date fechacCita, String horaCita, String estado) {
        this.paciente = paciente;
        this.medico = medico;
        this.fechacCita = fechacCita;
        HoraCita = horaCita;
        this.estado = estado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Date getFechacCita() {
        return fechacCita;
    }

    public void setFechacCita(Date fechacCita) {
        this.fechacCita = fechacCita;
    }

    public String getHoraCita() {
        return HoraCita;
    }

    public void setHoraCita(String horaCita) {
        HoraCita = horaCita;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Paciente: " + paciente + "   Medico: " + medico + "   Fechac cita: " + fechacCita + "  Hora:"
                + HoraCita + "   Estado: " + estado;
    }

}