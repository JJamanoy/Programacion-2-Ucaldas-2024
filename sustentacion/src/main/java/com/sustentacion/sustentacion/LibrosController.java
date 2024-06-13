package com.sustentacion.sustentacion;

import com.sustentacion.sustentacion.domain.Libros;
import com.sustentacion.sustentacion.services.LibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibrosController {

    @Autowired
    private LibrosService librosService;

    @GetMapping
    public ResponseEntity<List<Libros>> listarLibros() {
        List<Libros> libros = librosService.listarLibros();
        return ResponseEntity.ok(libros);
    }

    @PostMapping
    public ResponseEntity<Libros> agregarLibro(@RequestBody Libros libro) {
        Libros nuevoLibro = librosService.agregarLibro(libro);
        return ResponseEntity.ok(nuevoLibro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libros> editarLibro(@PathVariable int id, @RequestBody Libros libroDetalles) {
        Libros libroActualizado = librosService.editarLibro(id, libroDetalles);
        if (libroActualizado != null) {
            return ResponseEntity.ok(libroActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable int id) {
        librosService.eliminarLibro(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Libros>> buscarLibros(@RequestParam(required = false) String titulo,@RequestParam(required = false) String autor, @RequestParam(required = false) String genero) {
        List<Libros> libros;
        if (titulo != null) {
            libros = librosService.buscarLibrosPorTitulo(titulo);
        } else if (autor != null) {
            libros = librosService.buscarLibrosPorAutor(autor);
        } else if (genero != null) {
            libros = librosService.buscarLibrosPorGenero(genero);
        } else {
            libros = librosService.listarLibros(); // Devuelve todos los libros si no hay parámetros
        }
        return ResponseEntity.ok(libros);
    }
}