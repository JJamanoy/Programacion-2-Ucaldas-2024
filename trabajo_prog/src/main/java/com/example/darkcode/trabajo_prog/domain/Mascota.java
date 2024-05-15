package com.example.darkcode.trabajo_prog.domain;
import lombok.Data;

@Data
public class Mascota {
    private String tipo_mascota;
    private String nombre;
    private String sexo;
    private String edad;
    private String nombre_clinica_veterinaria;

    public void setTipo_Mascota(String tipo_mascota){
        this.tipo_mascota = tipo_mascota;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
    public void setEdad(String edad){
        this.edad = edad;
    }
    public void setNombre_clinica_veterinaria(String nombre_clinica_veterinaria){
        this.nombre_clinica_veterinaria = nombre_clinica_veterinaria;
    }
}
