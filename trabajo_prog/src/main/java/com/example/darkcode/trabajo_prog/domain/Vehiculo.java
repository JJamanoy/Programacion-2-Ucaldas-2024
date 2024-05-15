package com.example.darkcode.trabajo_prog.domain;

import lombok.Data;

@Data
public class Vehiculo {
    private String tipo_vehiculo;
    private String marca;
    private String modelo;
    private String color;

    
    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
