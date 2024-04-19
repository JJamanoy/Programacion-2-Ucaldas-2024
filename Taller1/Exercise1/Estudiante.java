public class Estudiante {
    String nombre = "";
    String codigo = "";
    String carrera = "";
    Double promedio = 0.0;

    public Estudiante(String nombre_param, String codigo_param, String carrera_param, Double promedio_param) {
        this.nombre = nombre_param;
        this.codigo = codigo_param;
        this.carrera = carrera_param;
        this.promedio = promedio_param;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCarrera() {
        return carrera;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "   Codigo: " + codigo + "   Carrera: " + carrera + "    Promedio: " + promedio;
    }
}