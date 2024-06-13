package com.sustentacion.sustentacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sustentacion.sustentacion.domain.Libros;

public interface LibrosRepository extends JpaRepository<Libros, Integer>{
    List<Libros> findByTituloContaining(String titulo);
    List<Libros> findByAutorContaining(String autor);
    List<Libros> findByGeneroContaining(String genero);
}
