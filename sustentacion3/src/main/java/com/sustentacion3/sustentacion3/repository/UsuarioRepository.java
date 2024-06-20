package com.sustentacion3.sustentacion3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sustentacion3.sustentacion3.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    List<Usuario> findByNombre(String nombre);
    
}
