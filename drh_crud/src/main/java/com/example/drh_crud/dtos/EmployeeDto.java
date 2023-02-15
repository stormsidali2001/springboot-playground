package com.example.drh_crud.dtos;

import com.example.drh_crud.entities.Departement;
import com.example.drh_crud.entities.Diplome;
import com.example.drh_crud.entities.Project;
import com.example.drh_crud.types.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.Optional;

@Data @AllArgsConstructor @NoArgsConstructor
public class EmployeeDto {

    private String name;

    private Genre genre;

    private Date starting_work_date;

    private String email;

    @ToString.Exclude
    private Optional<Diplome> diplome;


}
