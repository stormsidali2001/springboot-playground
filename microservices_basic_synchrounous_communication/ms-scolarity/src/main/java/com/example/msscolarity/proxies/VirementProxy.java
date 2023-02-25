package com.example.msscolarity.proxies;

import com.example.msscolarity.models.Virement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="ms-bourse",url = "localhost:8081")
public interface VirementProxy {
    @GetMapping("/virements/search/findAllByEtudiantIdEtudiant")
    CollectionModel<Virement> getVirements(@RequestParam("idEtudiant") Long ide , @RequestParam("projection") String projection);
}
