package com.sustentacion3.sustentacion3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sustentacion3.sustentacion3.domain.Usuario;
import com.sustentacion3.sustentacion3.services.UsuarioServices;

@Controller
public class InterfazController {
    
    @Autowired
    private UsuarioServices usuarioService;
    
    @GetMapping("/usuario")
    public String watchUsuarios(Model model){
        model.addAttribute("usuarioListAttribute", usuarioService.listarUsuarios());
        return "Usuarios";
    }

    @GetMapping("/añadirUsuario")
    public String agregarUsuario(Model model){
        model.addAttribute("addUsuario", new Usuario());
        return "añadirUsuario";
    }

    @PostMapping("/añadirUsuario")
    public String saveUsuario(@ModelAttribute("addUsuario")Usuario usuario){
        usuarioService.agregarUsuario(usuario);
        return "redirect:/usuario";
    }
}
