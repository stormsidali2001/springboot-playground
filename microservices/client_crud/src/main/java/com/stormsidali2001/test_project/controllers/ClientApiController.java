package com.stormsidali2001.test_project.controllers;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.stormsidali2001.test_project.entities.*;
import java.util.List;
import java.util.Map;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.stormsidali2001.test_project.repositories.*;



@RestController
@RequestMapping("client-api")
public class ClientApiController {

    
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CompteRepository compteRepository;

    
  
    @GetMapping("/client/all") 
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<?> getClientById(@PathVariable("id") Long id) {

        Client client = clientRepository.findById(id).get();
        if(client == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(client);
        }
    }

    @GetMapping("/client")
    public ResponseEntity<?> getClientByIdQueryParam(@RequestParam("id") Long id) {
        Client client = clientRepository.findById(id).get();
        if(client == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(client);
        }
    }


    @PostMapping("/client")
    Client createNewClient(@RequestBody Client client){
        return clientRepository.save(client);
    } 
    @PostMapping("/compte")
    ResponseEntity<?> createNewCompte(@RequestBody Map<String,Object> payload){
        Long idClient = (Long) payload.get("idClient");
        Client client = clientRepository.findById(idClient).get();
        if(client == null) {
            return ResponseEntity.notFound().build();
        }

        Compte c = new Compte();
        c.setLogin((String) payload.get("login"));
        c.setPassword((String) payload.get("password"));
        c.setClient(client);
        c.setDateCreation(new Date());
        compteRepository.save(c);
        return ResponseEntity.ok( c);
    
    }

    @PutMapping("id")
    Client updateClient(@PathVariable("id") Long id,@RequestBody Client client){
        if(!clientRepository.findById(id).isPresent()) {
            return null;
        }

        return clientRepository.save(client);
    }

    @DeleteMapping("/client/{id}")  
    public ResponseEntity<?> DeleteClient(@PathVariable(value = "id") Long id){

    if (clientRepository.findById(id).isPresent()){
       clientRepository.deleteById(id);
       return ResponseEntity.ok().build();
    }
    return ResponseEntity.badRequest().build();
    
    }



}
