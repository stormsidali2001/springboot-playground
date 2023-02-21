package com.example.msscolarity.proxies;

import com.example.msscolarity.models.Virement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="ms-bourse",url = "localhost:8081")
public interface VirementProxy {
    @GetMapping("virements/{idv}")
    Virement getVirement(@PathVariable("idv") Long idv , @RequestParam("projection") String projection);
}
