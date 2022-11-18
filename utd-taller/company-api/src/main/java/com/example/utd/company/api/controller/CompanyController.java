package com.example.utd.company.api.controller;

import com.example.utd.company.api.Model.CompanyCreateRequest;
import com.example.utd.company.api.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/company")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity getAllCompany()
    {
       return ResponseEntity.ok(companyService.listAllCompany());
    }

    //Mandar llamar el formulario
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody CompanyCreateRequest companyCreateRequest)
    {
        log.info("[i] add");
        return ResponseEntity.ok(companyService.addCompany(companyCreateRequest));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity getCompany(@PathVariable("name") String name)
    {
        log.info("[i] getCompany");
        return ResponseEntity.ok(companyService.getCompanyName(name));
    }


}
