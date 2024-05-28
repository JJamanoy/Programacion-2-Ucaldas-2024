package com.example.darkcode.app.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.darkcode.app.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    Employee buscarEmpleado(Long id);
    void GuardarEmpleado(Employee employee);
}
