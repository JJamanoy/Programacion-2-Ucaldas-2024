package com.sustentacion.sustentacion.services;

import com.sustentacion.sustentacion.domain.Libros;
import com.sustentacion.sustentacion.repository.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibrosService {

    @Autowired
    private LibrosRepository librosRepository;

    public List<Libros> listarLibros() {
        return librosRepository.findAll();
    }

    public Libros agregarLibro(Libros libro) {
        return librosRepository.save(libro);
    }

    public Libros editarLibro(Integer id, Libros libroDetalles) {
        Optional<Libros> libroOptional = librosRepository.findById(id);
        if (libroOptional.isPresent()) {
            Libros libro = libroOptional.get();
            libro.setTitulo(libroDetalles.getTitulo());
            libro.setAutor(libroDetalles.getAutor());
            libro.setGenero(libroDetalles.getGenero());
            libro.setFecha_publicacion(libroDetalles.getFecha_publicacion());
            libro.setIsbn(libroDetalles.getIsbn());
            libro.setCantidad_disponible(libroDetalles.getCantidad_disponible());
            return librosRepository.save(libro);
        } else {
            return null; 
        }
    }

    public void eliminarLibro(Integer id) {
        librosRepository.deleteById(id);
    }

    public List<Libros> buscarLibrosPorTitulo(String titulo) {
        return librosRepository.findByTituloContaining(titulo);
    }

    public List<Libros> buscarLibrosPorAutor(String autor) {
        return librosRepository.findByAutorContaining(autor);
    }

    public List<Libros> buscarLibrosPorGenero(String genero) {
        return librosRepository.findByGeneroContaining(genero);
    }
}