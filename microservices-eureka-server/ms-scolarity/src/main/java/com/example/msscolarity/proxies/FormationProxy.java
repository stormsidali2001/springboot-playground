package com.example.msscolarity.proxies;

import com.example.msscolarity.models.Formation;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ms-formation")
@LoadBalancerClient(name="ms-formation")
public interface FormationProxy {
    @GetMapping("/formations/{idf}")
    Formation getFormation(@PathVariable("idf") Long idf);
}
