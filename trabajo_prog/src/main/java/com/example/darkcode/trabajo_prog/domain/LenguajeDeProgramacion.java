package com.example.darkcode.trabajo_prog.domain;
import lombok.Data;

@Data
public class LenguajeDeProgramacion {
    private String lenguaje;
    private String tipo_paradigma;
    private String frameworks;

    public void setlenguaje(String lenguaje){
        this.lenguaje = lenguaje;
    }

    public void setTipo_paradigma(String tipo_paradigma) {
        this.tipo_paradigma = tipo_paradigma;
    }

    public void setFrameworks(String frameworks) {
        this.frameworks = frameworks;
    }

    
}
