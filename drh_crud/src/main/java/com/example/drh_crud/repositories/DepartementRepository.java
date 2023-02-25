package com.example.drh_crud.repositories;

import com.example.drh_crud.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DepartementRepository extends JpaRepository<Departement,Long> {
}
