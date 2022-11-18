package com.example.utd.taller.controller;

import com.example.utd.taller.Model.EmployeeCreateRequest;
import com.example.utd.taller.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/empleados")
public class EmpleadosController {

    private EmployeeService empleadosService;

    public EmpleadosController(EmployeeService empleadosService) {
        this.empleadosService = empleadosService;
    }

    @GetMapping
    public ResponseEntity listAllEmpleados()
    {
       return ResponseEntity.ok(empleadosService.listAllEmpleados());
    }

    //Mandar llamar el formulario
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody EmployeeCreateRequest employeeCreateRequest)
    {
        log.info("[i] add");
        return ResponseEntity.ok(empleadosService.addEmpleados(employeeCreateRequest));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getEmployee(@PathVariable("id") String id)
    {
        log.info("[i] getEmployee");
        return ResponseEntity.ok(empleadosService.getEmployeeById(id));
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity delete(@PathVariable("id") String id){
        log.info("[i] delete");
        return ResponseEntity.ok(empleadosService.deleteEmployee(id));
    }


}
