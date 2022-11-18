package com.example.utd.company.api.service;


import com.example.utd.company.api.Model.Company;
import com.example.utd.company.api.Model.CompanyCreateRequest;

import java.util.List;

public interface CompanyService {

    public abstract List<Company> listAllCompany();

    //Metodo para agregar
     Company addCompany(CompanyCreateRequest c);

    //Encontrar empleado con el id
     Company getCompanyName(String id);

}
