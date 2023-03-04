package com.example.msformation.Api;

import com.example.msformation.entities.Formation;
import com.example.msformation.model.Etudiant;
import com.example.msformation.proxy.EtudiantProxy;
import com.example.msformation.repositories.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
@RefreshScope //use http://192.168.43.118:8082/actuator/refresh to refresh the data
public class FormationController {
    @Autowired
    FormationRepository formationRepository;

    @Autowired
    EtudiantProxy etudiantProxy;

    @Value("${mes-config.email}")
    public String email;


    @GetMapping("email")
    public String getEmail(){
        return this.email;
    }

    @GetMapping("formations/{idf}")
    Formation getFormationWithStudents(@PathVariable("idf") Long idf ) {
    Formation formation = formationRepository.findById(idf).get();

    CollectionModel<Etudiant> col_etudiants = etudiantProxy.getEtudiant(idf,"toformation");
    System.out.print("col students : -------------------------------");
    System.out.print(col_etudiants);

    List<Etudiant> etudiants = new ArrayList<>(col_etudiants.getContent());
    formation.setEtudiants(etudiants);
    return formation;
    }
}
