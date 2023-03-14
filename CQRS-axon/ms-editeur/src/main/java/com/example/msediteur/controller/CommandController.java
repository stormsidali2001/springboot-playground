package com.example.msediteur.controller;


import com.example.coreapi.commands.EditeurCreationCommand;
import com.example.msediteur.dto.EditeurDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("command")
public class CommandController {
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping("editeur")
    public CompletableFuture<String> addEditeur(@RequestBody EditeurDto editeur){
      return  commandGateway.send(
                EditeurCreationCommand.builder()
                        .name(editeur.getName())
                        .editeurId(editeur.getEditeurId())
                        .pays(editeur.getPays())
                        .build()
        );

    }
}
