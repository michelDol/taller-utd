package com.example.utd.taller.service.impl;

import com.example.utd.taller.Model.Company;
import com.example.utd.taller.Model.Employee;
import com.example.utd.taller.Model.EmployeeCreateRequest;
import com.example.utd.taller.repository.EmployeeRepository;
import com.example.utd.taller.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private RestTemplate restTemplate;
    @Value("${api.url}")
    private String url;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               RestTemplate restTemplate) {
        this.employeeRepository = employeeRepository;
        this.restTemplate = restTemplate;
    }


    @Override
    public List<Employee> listAllEmpleados() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmpleados(EmployeeCreateRequest s) {
        Employee employee=new Employee();

      Company company=  this.connectService(s.getNameCompany());
        BeanUtils.copyProperties(s,employee);
        employee.setCompany(company!=null? company.getId() : "No existe");

       employee= employeeRepository.save(employee);
return employee;

    }

    @Override
    public Employee getEmployeeById(String id) {

            return employeeRepository.findById(id).get();    }

    @Override
    public Employee deleteEmployee(String id) {
      Optional<Employee> employee= employeeRepository.findById(id);
      if (employee.isPresent())
      {
          employeeRepository.delete(employee.get());
      }
        return employee.get();
    }

     private Company connectService(String name){
        Company respuesta=null;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("accept", "application/json");


            HttpEntity requestEntity = new HttpEntity(headers);
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity<Company> response =
                    restTemplate.exchange(url + name, HttpMethod.GET, requestEntity,
                            Company.class);

            log.info("[i] respuesta connectService {}", response.getBody());
            return response.getBody();
        }catch (Exception e){
            e.printStackTrace();
        }
        return respuesta;
    }

}
