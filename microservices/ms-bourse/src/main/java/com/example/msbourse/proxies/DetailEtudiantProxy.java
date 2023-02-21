package com.example.msbourse.proxies;

import com.example.msbourse.entities.Etudiant;
import com.example.msbourse.models.DetailEtudiant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="ms-scolarity",url="localhost:8083")
public interface DetailEtudiantProxy {
    @GetMapping("/etudiants/{ide}")
    DetailEtudiant getDetailEtudiant(@PathVariable("ide") Long ide , @RequestParam("projection") String projection);
}
