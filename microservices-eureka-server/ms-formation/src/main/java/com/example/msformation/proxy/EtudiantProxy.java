package com.example.msformation.proxy;

import com.example.msformation.model.Etudiant;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="ms-scolarity")
@LoadBalancerClient(name="ms-scolarity")
public interface EtudiantProxy {
    @GetMapping("/etudiants/search/findEtudiantsByIdFormation")
    CollectionModel<Etudiant> getEtudiant(@RequestParam("idf") Long idf , @RequestParam("projection") String projection);
}
