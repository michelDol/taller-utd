package com.example.utd.company.api.service.impl;

import com.example.utd.company.api.Model.Company;
import com.example.utd.company.api.Model.CompanyCreateRequest;
import com.example.utd.company.api.repository.CompanyRepository;
import com.example.utd.company.api.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public List<Company> listAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company addCompany(CompanyCreateRequest c) {
        Company company=new Company();
        BeanUtils.copyProperties(c,company);
        company= companyRepository.save(company);
        return company;
    }

    @Override
    public Company getCompanyName(String name) {
        return companyRepository.findByName(name);
    }
}
