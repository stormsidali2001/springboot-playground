package com.stormsidali2001.test_project.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stormsidali2001.test_project.entities.Compte;

@RepositoryRestResource
public interface CompteRepository  extends JpaRepository<Compte, Long> {
    
}
