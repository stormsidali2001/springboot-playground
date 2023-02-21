package com.example.msformation.proxy;

import com.example.msformation.model.Etudiant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="ms-scolarity",url="localhost:8083")
public interface EtudiantProxy {
    @GetMapping("/etudiants/search/findEtudiantsByIdFormation")
    CollectionModel<Etudiant> getEtudiant(@RequestParam("idf") Long idf , @RequestParam("projection") String projection);
}
