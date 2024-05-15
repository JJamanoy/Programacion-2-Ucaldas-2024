package com.example.darkcode.trabajo_prog.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_LENGUAJEPROG")
public class LenguajeDeProgRepository {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="lenguaje")
    private String lenguaje;
    @Column(name="tipo_paradigma")
    private String tipo_paradigma;
    @Column(name="frameworks")
    private String frameworks;
}
