package com.example.darkcode.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.darkcode.app.domain.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> listaEmpleados() {
        if(employees == null)
            return new ArrayList<>();
        return employees;
    }

    @Override
    public void GuardarEmpleado(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void EliminarEmpleado(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public Employee mostrarEmpleado(Long id) {
        return employees.stream().filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
}
