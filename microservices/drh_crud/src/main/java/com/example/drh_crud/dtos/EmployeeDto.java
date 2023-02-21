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
public class EmployeeDto implements  Cloneable{

    private String name;

    private Genre genre;

    private Date starting_work_date;

    private String email;

    @ToString.Exclude
    private Optional<Diplome> diplome;


    @Override
    public EmployeeDto clone() {
        try {
            EmployeeDto clone = new EmployeeDto();
            clone.setName(this.name);
            clone.setGenre(this.genre);
            clone.setStarting_work_date(this.starting_work_date);
            clone.setEmail(this.email);
            clone.setDiplome(this.diplome);
            return clone;
        } catch ( Exception e) {
            throw new AssertionError(e);
        }
    }
}
