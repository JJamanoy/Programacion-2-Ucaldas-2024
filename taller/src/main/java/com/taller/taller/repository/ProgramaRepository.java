package com.taller.taller.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_PROGRAMA")
public class ProgramaRepository {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="level_study")
    private String level_study;
    @Column(name="name")
    private String name;
    @Column(name="credits")
    private Integer credits;
    @Column(name="status")
    private Boolean status;
}
