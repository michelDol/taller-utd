package com.example.utd.taller.service;


import com.example.utd.taller.Model.Employee;
import com.example.utd.taller.Model.EmployeeCreateRequest;

import java.util.List;

public interface EmployeeService {

    //Metodo para Listar
    public abstract List<Employee> listAllEmpleados();

    //Metodo para agregar
     Employee addEmpleados(EmployeeCreateRequest s);

    //Encontrar empleado con el id
     Employee getEmployeeById(String id);

    //Eliminar empleado con id
    Employee deleteEmployee(String id);

}
