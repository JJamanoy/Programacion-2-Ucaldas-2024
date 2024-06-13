package com.sustentacion.sustentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sustentacion.sustentacion.domain.Libros;
import com.sustentacion.sustentacion.domain.Usuarios;
import com.sustentacion.sustentacion.services.LibrosService;
import com.sustentacion.sustentacion.services.UsuarioService;


@Controller
public class InterfazController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private LibrosService librosService;

    /*********
    LIBROS
    **************/
    @GetMapping("/libros")
    public String listarLibros(Model model) {
        model.addAttribute("librosListAttribute", librosService.listarLibros());
        return "Libros";
    }
    @GetMapping("/add-libros")
    public String agregarLibros(Model model) {
        model.addAttribute("addLibros", new Libros());
        return "add-libros";
    }
    @PostMapping("/add-libros")
    public String guardarLibro(@ModelAttribute("addLibros")Libros libros) {
        librosService.agregarLibro(libros);
        return "redirect:/libros";
    }


    /************
    USUARIOS
    ****************/
    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuariosListAttribute", usuarioService.listarUsuarios());
        return "Usuarios";
    }

    @GetMapping("/add-usuarios")
    public String agregarUsuarios(Model model) {
        model.addAttribute("addUsuarios", new Usuarios());
        return "add-usuarios";
    }

    @PostMapping("/add-usuarios")
    public String guardarUsuario(@ModelAttribute("addUsuarios")Usuarios usuarios) {
        usuarioService.agregarUsuario(usuarios);
        return "redirect:/usuarios";
    }
}
