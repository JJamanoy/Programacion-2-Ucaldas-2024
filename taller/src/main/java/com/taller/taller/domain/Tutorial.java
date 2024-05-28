package com.taller.taller.domain;

import lombok.Data;

@Data
public class Tutorial {
    private Long id;
    private String name;
    private String descripcion;
    private String url;
    private String fecha;
    private String autor;
    private boolean estado;

    public Tutorial(){}

    public String getName(){
        return name;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public String getUrl(){
        return url;
    }
    public String getFecha(){
        return fecha;
    }
    public String getAutor(){
        return autor;
    }

    public Boolean getEstado(){
        return estado;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public void setEstado(Boolean estado){
        this.estado=estado;
    }
}



