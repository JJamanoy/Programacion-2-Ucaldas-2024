package com.sustentacion.sustentacion.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_LIBROS")
public class Libros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Titulo")
    private String titulo;

    @Column(name = "Autor")
    private String autor;

    @Column(name = "Genero")
    private String genero;

    @Column(name = "Fecha_Publicacion")
    private String fecha_publicacion;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "Cantidad_Disponible", nullable = false)
    private int cantidad_disponible;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Imagen Portada")
    private String imagen_portada;

    public Libros() {}

    public Libros(String titulo, String autor, String genero, String fecha_publicacion, String isbn,
            int cantidad_disponible, String descripcion, String imagen_portada) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.fecha_publicacion = fecha_publicacion;
        this.isbn = isbn;
        this.cantidad_disponible = cantidad_disponible;
        this.descripcion = descripcion;
        this.imagen_portada = imagen_portada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(int cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen_portada() {
        return imagen_portada;
    }

    public void setImagen_portada(String imagen_portada) {
        this.imagen_portada = imagen_portada;
    }

    @Override
    public String toString() {
        return "Libros [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", genero=" + genero
                + ", fecha_publicacion=" + fecha_publicacion + ", isbn=" + isbn + ", cantidad_disponible="
                + cantidad_disponible + ", descripcion=" + descripcion + ", imagen_portada=" + imagen_portada + "]";
    }
    
}
