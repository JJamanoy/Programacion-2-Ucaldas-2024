package com.example.darkcode.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.darkcode.app.domain.Employee;
import com.example.darkcode.app.services.EmployeeService;



@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String home() {
        return "home";
    }
/* 
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/saludo")
    public String saludo(Model model) {
        model.addAttribute("mensaje", "Hola desde vista");
        return "saludo";
    }

    @GetMapping("/employee")
    public String informacionEmpleado(Model model) {
        Employee empleado = new Employee();
        empleado.setFullname("yaneth mejia");
        empleado.setUser_email("yanethmejia@gmail.com");
        model.addAttribute("employeeAtributtes", empleado);
        return "show_employee";
    }
*/
    @GetMapping("/employees")
    public String listarEmpleados(Model model) {
        model.addAttribute("employeeListAttribute", employeeService.listaEmpleados());
        return "employees";
    }

    @GetMapping("/new-employee")
    public String showAddEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "add_employee";
    }

    @PostMapping("/new-employee")
    public String GuardarEmpleado(@ModelAttribute("employee") Employee employee) {
        employeeService.GuardarEmpleado(employee);
        return "redirect:/employees";
    }
}
