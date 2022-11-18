package com.example.utd.taller.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "employee")
public class Employee  implements Serializable {
    @Id
    private String id;
    private String name;
    private String lastName;
    private int age;
    private String position;
    private String curp;
   private String company;


}
