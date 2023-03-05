package com.example.msserver.proxy;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="ms-user")
@LoadBalancerClient(name="ms-user")
public interface UserProxy {
    @GetMapping("/virtualMachines/search/sumRamServer")
    @CircuitBreaker(name="ms-user",fallbackMethod = "defaultSum")
    public Long getRamSum(@RequestParam("ids") Long ids);

    public default  Long defaultSum(Throwable throwable){
        return 0L;
    }
}
