package com.example.utd.company.api.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CompanyCreateRequest {

    private String name;
    private String address;
    private int numberEmploye;
    private String owner;
    private String type;



}
