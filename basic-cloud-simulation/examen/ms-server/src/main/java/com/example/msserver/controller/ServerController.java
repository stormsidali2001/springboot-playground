package com.example.msserver.controller;


import com.example.msserver.Entities.Server;
import com.example.msserver.Repositories.ServerRepository;
import com.example.msserver.proxy.UserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api")
public class ServerController {
    @Autowired
    private ServerRepository serverRepository;

    @Autowired
    UserProxy userProxy;

    @GetMapping("remaining-ram/{ids}")
    public Long getRemainingRam(@PathVariable("ids") Long ids){
        Optional<Server> serverOp = serverRepository.findById(ids);
        if(serverOp.isEmpty()) return null;

        Server server = serverOp.get();
        return server.getConfiguration().getRam() -   userProxy.getRamSum(server.getId());


    }
    @GetMapping("t1")
    public String s(){
        return "sidali assoul";
    }
}
