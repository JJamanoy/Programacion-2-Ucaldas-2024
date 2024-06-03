package com.taller.taller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.taller.taller.domain.Programa;
import com.taller.taller.services.ProgramaService;

@Controller
public class ProgramaController {
    
    @Autowired
    private ProgramaService programaService;

    @GetMapping("/")
    public String Home(){
        return "home";
    }

    @GetMapping("/programas")
    public String listaProgramas(Model model){
        model.addAttribute("programaListAttribute", programaService.listaProgramas());
        return "programas";
    }

    @GetMapping("/new-programa")
    public String showaddPrograma(Model model){
        model.addAttribute("programa", new Programa());
        return "add_programa";
    } 

    @PostMapping("/new-programa")
    public String GuardarPrograma(@ModelAttribute("programa") Programa programa){
        programaService.GuardarPrograma(programa);
        return "redirect:/programas";
    }

    @GetMapping("/showPrograma/{name}")
    public String showPrograma(@PathVariable("name") String name, Model model){
        model.addAttribute("programa", programaService.mostrarPrograma(name));
        return "show_programa";
    }
}
