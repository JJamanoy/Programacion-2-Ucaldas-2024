package com.example.darkcode.trabajo_prog;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.darkcode.trabajo_prog.domain.LenguajeDeProgramacion;

@Controller
public class LenguajeProgController {
    @GetMapping("/listar_lenguaje")
    public String listar_lenguajes(Model model){
        LenguajeDeProgramacion lenguaje1 = new LenguajeDeProgramacion();
        LenguajeDeProgramacion lenguaje2 = new LenguajeDeProgramacion();
        LenguajeDeProgramacion lenguaje3 = new LenguajeDeProgramacion();
    
        lenguaje1.setlenguaje("C++");
        lenguaje1.setTipo_paradigma("Programacion Imperativa");
        lenguaje1.setFrameworks("TreeFrog");

        lenguaje2.setlenguaje("Phyton");
        lenguaje2.setTipo_paradigma("Programacion Procedimental");
        lenguaje2.setFrameworks("Django");

        lenguaje3.setlenguaje("Java");
        lenguaje3.setTipo_paradigma("Programacion Orientado a Objetos");
        lenguaje3.setFrameworks("Springboot");

        ArrayList<LenguajeDeProgramacion> list_lenguaje = new ArrayList<>();

        list_lenguaje.add(lenguaje1);
        list_lenguaje.add(lenguaje2);
        list_lenguaje.add(lenguaje3);

        model.addAttribute("ListarLenguajeAttribute", list_lenguaje);
        return "listar_lenguajes";
    }

    @GetMapping("/mostrar_lenguaje")
    public String mostrar_lenguajes(Model model){
        LenguajeDeProgramacion lenguaje1 = new LenguajeDeProgramacion();
        LenguajeDeProgramacion lenguaje2 = new LenguajeDeProgramacion();
        LenguajeDeProgramacion lenguaje3 = new LenguajeDeProgramacion();
    
        lenguaje1.setlenguaje("C++");
        lenguaje1.setTipo_paradigma("Programacion Imperativa");
        lenguaje1.setFrameworks("TreeFrog");

        lenguaje2.setlenguaje("Phyton");
        lenguaje2.setTipo_paradigma("Programacion Procedimental");
        lenguaje2.setFrameworks("Django");

        lenguaje3.setlenguaje("Java");
        lenguaje3.setTipo_paradigma("Programacion Orientado a Objetos");
        lenguaje3.setFrameworks("Springboot");

        ArrayList<LenguajeDeProgramacion> list_lenguaje = new ArrayList<>();
        ArrayList<LenguajeDeProgramacion> most_lenguaje = new ArrayList<>();

        list_lenguaje.add(lenguaje1);
        list_lenguaje.add(lenguaje2);
        list_lenguaje.add(lenguaje3);

        /* PARAMETRO QUE SE VA A USAR */
        // Solo los que tengan como nombre de lenguaje Java, por lo que solo debe de aparecer un elemento que es lenguaje 3
        String lenguaje = "Java";
        for (LenguajeDeProgramacion lenguaje_x : list_lenguaje) {
            if(lenguaje.equals(lenguaje_x.getLenguaje())){
                most_lenguaje.add(lenguaje_x);
            }
        }

        model.addAttribute("MostrarLenguajeAttribute", most_lenguaje);
        return "mostrar_lenguajes";
    }
}
