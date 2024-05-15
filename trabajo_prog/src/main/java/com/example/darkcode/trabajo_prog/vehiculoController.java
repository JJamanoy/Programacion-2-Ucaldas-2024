package com.example.darkcode.trabajo_prog;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.darkcode.trabajo_prog.domain.Vehiculo;

@Controller
public class vehiculoController {
    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/listar_vehiculo")
    public String vehiculo_listar(Model model) {
        Vehiculo vehiculo1= new Vehiculo();
        Vehiculo vehiculo2= new Vehiculo();
        Vehiculo vehiculo3= new Vehiculo();

        vehiculo1.setTipo_vehiculo("Moto");
        vehiculo1.setModelo("2024");
        vehiculo1.setMarca("Yamaha");
        vehiculo1.setColor("Negro");

        vehiculo2.setTipo_vehiculo("Jeep");
        vehiculo2.setModelo("2015");
        vehiculo2.setMarca("Lands Rover");
        vehiculo2.setColor("Blanco");

        vehiculo3.setTipo_vehiculo("Carro");
        vehiculo3.setModelo("2020");
        vehiculo3.setMarca("Renault");
        vehiculo3.setColor("Azul");
        
        ArrayList<Vehiculo> vehiculo_list = new ArrayList<>();

        vehiculo_list.add(vehiculo1);
        vehiculo_list.add(vehiculo2);
        vehiculo_list.add(vehiculo3);
        model.addAttribute("vehiculoAttribute", vehiculo_list);
        return "vehiculo";

    }
    
    @GetMapping("/mostrar_vehiculo")
    public String vehiculo_mostrar(Model model){
        Vehiculo vehiculo1= new Vehiculo();
        Vehiculo vehiculo2= new Vehiculo();
        Vehiculo vehiculo3= new Vehiculo();

        vehiculo1.setTipo_vehiculo("Moto");
        vehiculo1.setModelo("2024");
        vehiculo1.setMarca("Yamaha");
        vehiculo1.setColor("Negro");

        vehiculo2.setTipo_vehiculo("Jeep");
        vehiculo2.setModelo("2015");
        vehiculo2.setMarca("Lands Rover");
        vehiculo2.setColor("Blanco");

        vehiculo3.setTipo_vehiculo("Carro");
        vehiculo3.setModelo("2020");
        vehiculo3.setMarca("Renault");
        vehiculo3.setColor("Azul");
        
        ArrayList<Vehiculo> vehiculo_list = new ArrayList<>();
        ArrayList<Vehiculo> vehiculo_mostrar = new ArrayList<>();

        vehiculo_list.add(vehiculo1);
        vehiculo_list.add(vehiculo2);
        vehiculo_list.add(vehiculo3);

        /* PARAMETRO QUE SE VA A USAR */
        // Solo los tipos carros, por lo que solo debe de aparecer un elemento que es el vehiculo 3
        String carro= "Carro";
        for (Vehiculo vehiculo : vehiculo_list) {
            if (carro.equals(vehiculo.getTipo_vehiculo())) {
                vehiculo_mostrar.add(vehiculo);
            }
        }
        
        model.addAttribute("vehiculeMostrarAttribute", vehiculo_mostrar);
        return "mostrar_vehiculos";
    }

}
