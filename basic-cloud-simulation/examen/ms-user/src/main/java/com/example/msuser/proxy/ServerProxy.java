package com.example.msuser.proxy;

import com.example.msuser.Model.ConfigurationModel;
import com.example.msuser.Model.ServerModal;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.ws.rs.Path;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ms-server")
@LoadBalancerClient(name="ms-server")
public interface ServerProxy {
    @GetMapping("/servers/{ids}")
    @CircuitBreaker(name="ms-server",fallbackMethod = "defaultServerModel")
    public ServerModal getServer(@PathVariable("ids") Long ids);
    public default ServerModal defaultServerModel(Throwable throwable){
        return ServerModal.builder()
                .configuration(
                        ConfigurationModel.builder()
                                .cpu(17L)
                                .ram(15L)
                                .diskSize(500L)
                                .build()
                )
                .id(1L)
                .datacenterName("Bejaia-data-center")
                .build();
    }
}
