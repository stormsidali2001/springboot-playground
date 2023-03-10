package com.example.msbourse.Api;

import com.example.msbourse.entities.Etudiant;
import com.example.msbourse.entities.Virement;
import com.example.msbourse.models.DetailEtudiant;
import com.example.msbourse.proxies.DetailEtudiantProxy;
import com.example.msbourse.repositories.EtudiantRepository;
import com.example.msbourse.repositories.VirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api")
public class DetailEtudiantController {
    @Autowired
    EtudiantRepository etudiantRepository;

    @Autowired
    DetailEtudiantProxy detailEtudiantProxy;

    @Autowired
    VirementRepository virementRepository;
    @GetMapping("etudiants/{ide}")
    ResponseEntity<?> getEtudiantWithDetails(@PathVariable("ide") Long ide){
        Optional<Etudiant> ep = etudiantRepository.findById(ide);
        if(ep.isEmpty()) return ResponseEntity.notFound().build();
        Etudiant e = ep.get();
        DetailEtudiant de = detailEtudiantProxy.getDetailEtudiant(ide,"detail_etudiant");
        e.setDetailEtudiant(de);
        return ResponseEntity.ok(e);

    }

    @GetMapping("virements/{ide}")
    ResponseEntity<?> getVirementEtudiants(@PathVariable("ide") Long ide){
        List<Virement> virements =virementRepository.findAllByEtudiantIdEtudiant(ide);
        return  ResponseEntity.ok(virements);

    }

}
