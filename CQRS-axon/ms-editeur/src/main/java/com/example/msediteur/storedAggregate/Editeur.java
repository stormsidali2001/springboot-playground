package com.example.msediteur.storedAggregate;

import com.example.coreapi.commands.EditeurCreationCommand;
import com.example.coreapi.events.EditeurCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.Id;

@Aggregate @Entity
@Builder @NoArgsConstructor @Data @AllArgsConstructor
public class Editeur {
    @AggregateIdentifier
    @Id
    private String idEditeur;

    private String name;

    private String pays;

    @CommandHandler
    public Editeur(EditeurCreationCommand cmd){
        Assert.notNull(cmd.getEditeurId(),"editeur id should not be null");
        Assert.notNull(cmd.getName(),"editeur name should not be null");
        AggregateLifecycle.apply(
                EditeurCreatedEvent.builder()
                        .editeurId(cmd.getEditeurId())
                        .name(cmd.getName())
                        .pays(cmd.getPays())
                        .build()
        );
    }

    @EventSourcingHandler
    public void on(EditeurCreatedEvent event){
        this.idEditeur = event.getEditeurId();
        this.name = event.getName();
    }
}
