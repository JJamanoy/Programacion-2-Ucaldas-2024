package com.taller.taller.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_TUTORIAL")
public class TutorialRepository {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="url")
    private String url;
    @Column(name="fecha")
    private String fecha;
    @Column(name="autor")
    private String autor;
    @Column(name="estado")
    private Boolean estado;
}
