package com.example.msuser.controller;


import com.example.msuser.Entities.VirtualMachine;
import com.example.msuser.Model.ServerModal;
import com.example.msuser.Repositories.VirtualMachineRepository;
import com.example.msuser.proxy.ServerProxy;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api")
public class ServerApiController {
    @Autowired
    VirtualMachineRepository virtualMachineRepository;

    @Autowired
    ServerProxy serverProxy;
    @GetMapping("virtual-machines-with-server/{idm}")
    public VirtualMachine getVirtualMachine(@PathVariable("idm") Long idm){
        Optional<VirtualMachine> vmOp = virtualMachineRepository.findById(idm);

        if(vmOp.isEmpty()) return null;
        VirtualMachine vm = vmOp.get();
        try {

            ServerModal s = serverProxy.getServer(vm.getServerId());
            vm.setServer(s);
            return vm;
        }catch (Exception e){
            throw new NotFoundException(e);
        }


    }
    @GetMapping("t1")
    public String t1(){
        return "sidali";
    }

}
