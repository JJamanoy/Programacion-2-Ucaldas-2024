package com.sustentacion.sustentacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sustentacion.sustentacion.domain.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, Integer>{
    
}