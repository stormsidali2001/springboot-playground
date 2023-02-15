package com.example.drh_crud.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class EmployeeWithDepartementDto extends EmployeeDto {
    private Long departementId;



}
