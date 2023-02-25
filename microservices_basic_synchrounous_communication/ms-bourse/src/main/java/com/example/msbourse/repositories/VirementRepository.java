package com.example.msbourse.repositories;

import com.example.msbourse.entities.Virement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.List;

@RepositoryRestResource
public interface VirementRepository extends JpaRepository<Virement, Long> {
    List<Virement> findAllByEtudiantIdEtudiant(Long idEtudiant);
}
