package com.example.darkcode.app.services;

import java.util.List;

import com.example.darkcode.app.domain.Employee;

public interface EmployeeService {
    List<Employee> listaEmpleados();
    void GuardarEmpleado(Employee employee);
    void EliminarEmpleado(Employee employee);
    Employee mostrarEmpleado(Long id);

}
