package com.example.darkcode.trabajo_prog.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_MASCOTA")
public class MascotaRepository {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="tipo_mascota")
    private String tipo_mascota;
    @Column(name="nombre")
    private String nombre;
    @Column(name="sexo")
    private String sexo;
    @Column(name="edad")
    private String edad;
    @Column(name="nombre_clinica_veterinaria")
    private String nombre_clinica_veterinaria;
}
