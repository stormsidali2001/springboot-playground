package com.example.msediteur.projection;

import com.example.coreapi.events.EditeurCreatedEvent;
import com.example.msediteur.repositories.EditeurRepository;
import com.example.msediteur.storedAggregate.Editeur;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.AbstractDocument;

@Component
public class EditeurProjection {
    @Autowired
    EditeurRepository editeurRepository;

    @EventHandler
    public void addEditeur(EditeurCreatedEvent event){
        editeurRepository.save(
                Editeur.builder()
                        .idEditeur(event.getEditeurId())
                        .name(event.getName())
                        .pays(event.getPays())
                        .build()
        );
    }
}
