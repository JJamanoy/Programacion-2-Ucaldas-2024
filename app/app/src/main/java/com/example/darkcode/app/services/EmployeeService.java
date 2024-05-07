package com.example.darkcode.app.services;

import java.util.List;

import com.example.darkcode.app.domain.Employee;

public interface EmployeeService {
    public List<Employee> listaEmpleados();
    public void GuardarEmpleado(Employee employee);
    public void EliminarEmpleado(Employee employee);
    public Employee mostrarEmpleado(Employee employee);
}
