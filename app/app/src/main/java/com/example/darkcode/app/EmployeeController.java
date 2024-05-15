package com.example.darkcode.app;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.darkcode.app.domain.Employee;



@Controller
public class EmployeeController {
    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("/saludo")
    public String saludo(Model model){
        model.addAttribute("mensaje", "Hola desde vista");
        return "saludo";
    }

    @GetMapping("/employee")
    public String informacionEmpleado(Model model){
        Employee empleado = new Employee();
        empleado.setFullname("Jeronimo Jamanoy");
        empleado.setUser_email("Jerojamanoy@gmail.com");
        model.addAttribute("employeeAtributtes", empleado);
        return "show_employee";
    }

    @GetMapping("/employees")
    public String listarEmpleado(Model model){
        Employee empleado1 = new Employee();
        Employee empleado2 = new Employee();
        empleado1.setFullname("Juan Felipe");
        empleado1.setUser_email("juanfelipe@gmail.com");
        empleado2.setFullname("Juan ");
        empleado2.setUser_email("juan@gmail.com");

        ArrayList<Employee> empleados = new ArrayList<>();
        empleados.add(empleado1);
        empleados.add(empleado2);
        model.addAttribute("employeeAtributtes", empleados);
        return "employees";

    }
}
