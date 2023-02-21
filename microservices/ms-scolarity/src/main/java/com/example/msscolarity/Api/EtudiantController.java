package com.example.msscolarity.Api;

import com.example.msscolarity.entities.Etudiant;
import com.example.msscolarity.models.Formation;
import com.example.msscolarity.models.Virement;
import com.example.msscolarity.proxies.FormationProxy;
import com.example.msscolarity.proxies.VirementProxy;
import com.example.msscolarity.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("api")
public class EtudiantController {
    @Autowired
    EtudiantRepository etudiantRepository;

    @Autowired
    FormationProxy formationProxy;

    @Autowired
    VirementProxy virementProxy;

    @GetMapping("etudiants/{ide}")
    ResponseEntity<?> GetStudentWithFormation(@PathVariable("ide") Long ide){
        Optional<Etudiant> ep = etudiantRepository.findById(ide);
        if(ep.isEmpty()) return ResponseEntity.notFound().build();
        Etudiant etudiant = ep.get();
        Formation formation = formationProxy.getFormation(etudiant.getIdFormation());
        etudiant.setFormation(formation);
        return ResponseEntity.ok(etudiant);
    }

    @GetMapping("etudiants-wih-virement/{ide}")
    ResponseEntity<?> GetStudentWithVirement(@PathVariable("ide") Long ide){

        Optional<Etudiant> ep = etudiantRepository.findById(ide);
        if(ep.isEmpty()) return ResponseEntity.notFound().build();
        Etudiant etudiant = ep.get();
        Virement virement = virementProxy.getVirement(ide,"virement");
        etudiant.setVirement(virement);
        return ResponseEntity.ok(etudiant);
    }
}
