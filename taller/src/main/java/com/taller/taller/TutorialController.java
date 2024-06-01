package com.taller.taller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.taller.taller.domain.Tutorial;
import com.taller.taller.services.TutorialService;

@Controller
public class TutorialController {
    
    @Autowired
    private TutorialService tutorialService;

    @GetMapping("/")
    public String Home(){
        return "home";
    }

    @GetMapping("/tutoriales")
    public String listaTutoriales(Model model){
        model.addAttribute("tutorialListAttribute", tutorialService.listaTutoriales());
        return "tutoriales";
    }

    @GetMapping("/new-tutorial")
    public String showaddTutorial(Model model){
        model.addAttribute("tutorial", new Tutorial());
        return "add_tutorial";
    }

    @PostMapping("/new-tutorial")
    public String GuardarTutorial(@ModelAttribute("tutorial") Tutorial tutorial){
        tutorialService.GuardarTutorial(tutorial);
        return "redirect:/tutoriales";
    }

    @GetMapping("/showTutorial/{name}")
    public String showTutorial(@PathVariable("name") String name, Model model){
        model.addAttribute("tutorial", tutorialService.mostrarTutorial(name));
        return "vista";
    }
}
