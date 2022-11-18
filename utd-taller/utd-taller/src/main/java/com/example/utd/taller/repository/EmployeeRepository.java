package com.example.utd.taller.repository;

import com.example.utd.taller.Model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
     Optional<Employee> findAllByCompany(String id);
}
