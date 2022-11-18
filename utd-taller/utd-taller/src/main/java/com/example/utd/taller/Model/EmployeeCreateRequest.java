package com.example.utd.taller.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeCreateRequest  {

    private String name;
    private String lastName;
    private int age;
    private String position;
    private String curp;
   private String nameCompany;


}
