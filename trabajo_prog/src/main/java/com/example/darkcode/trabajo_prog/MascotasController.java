package com.example.darkcode.trabajo_prog;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.darkcode.trabajo_prog.domain.Mascota;

@Controller
public class MascotasController {
    @GetMapping("/listar_mascota")
    public String listar_mascotas(Model model){
        Mascota mascota1 = new Mascota();
        Mascota mascota2 = new Mascota();
        Mascota mascota3 = new Mascota();

        mascota1.setTipo_Mascota("Pato");
        mascota1.setNombre("Lucas");
        mascota1.setSexo("Macho");
        mascota1.setEdad("10");
        mascota1.setNombre_clinica_veterinaria("San Juan de Dios");

        mascota2.setTipo_Mascota("Perro");
        mascota2.setNombre("Sabueso");
        mascota2.setSexo("Macho");
        mascota2.setEdad("13");
        mascota2.setNombre_clinica_veterinaria("San Juan de Dios");
        
        mascota3.setTipo_Mascota("Gato");
        mascota3.setNombre("Garfiela");
        mascota3.setSexo("Hembra");
        mascota3.setEdad("5");
        mascota3.setNombre_clinica_veterinaria("Municipal");

        ArrayList<Mascota> lista_mascotas = new ArrayList<>();

        lista_mascotas.add(mascota1);
        lista_mascotas.add(mascota2);
        lista_mascotas.add(mascota3);
        model.addAttribute("ListarMascotasAttribute", lista_mascotas);
        return "listar_mascotas";
    }

    @GetMapping("/mostrar_mascota")
    public String mostrar_mascotas(Model model){
        Mascota mascota1 = new Mascota();
        Mascota mascota2 = new Mascota();
        Mascota mascota3 = new Mascota();

        mascota1.setTipo_Mascota("Pato");
        mascota1.setNombre("Lucas");
        mascota1.setSexo("Macho");
        mascota1.setEdad("10");
        mascota1.setNombre_clinica_veterinaria("San Juan de Dios");

        mascota2.setTipo_Mascota("Perro");
        mascota2.setNombre("Sabueso");
        mascota2.setSexo("Macho");
        mascota2.setEdad("13");
        mascota2.setNombre_clinica_veterinaria("San Juan de Dios");
        
        mascota3.setTipo_Mascota("Gato");
        mascota3.setNombre("Garfiela");
        mascota3.setSexo("Hembra");
        mascota3.setEdad("5");
        mascota3.setNombre_clinica_veterinaria("Municipal");

        ArrayList<Mascota> lista_mascotas = new ArrayList<>();
        ArrayList<Mascota> mostrar_mascotas = new ArrayList<>();

        lista_mascotas.add(mascota1);
        lista_mascotas.add(mascota2);
        lista_mascotas.add(mascota3);

        /* PARAMETRO QUE SE VA A USAR */
        // Solo los que esten en el mismo hospital, por lo que solo deben de aparecer dos elementos que son mascota1 y mascota2

        String clinica = "San Juan de Dios";
        for (Mascota mascota : lista_mascotas) {
            if(clinica.equals(mascota.getNombre_clinica_veterinaria())){
                mostrar_mascotas.add(mascota);
            }
        }
        model.addAttribute("MostrarMascotasAttribute", mostrar_mascotas);
        return "mostrar_mascota";
    }
}
