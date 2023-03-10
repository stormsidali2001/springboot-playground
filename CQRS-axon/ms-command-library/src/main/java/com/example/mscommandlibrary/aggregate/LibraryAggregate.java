package com.example.mscommandlibrary.aggregate;

import com.example.coreapi.commands.AddBookCommand;
import com.example.coreapi.commands.LibraryCreationCommand;
import com.example.coreapi.events.LibraryCreatedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Aggregate
@NoArgsConstructor
public class LibraryAggregate {

    @CommandHandler
    public LibraryAggregate(LibraryCreationCommand cmd){
        Assert.notNull(cmd.getLibraryId(),"libraryId should be not null");
        Assert.notNull(cmd.getName(),"name should be not null");
        AggregateLifecycle.apply(
                LibraryCreatedEvent.builder()
                        .libraryId(cmd.getLibraryId())
                        .name(cmd.getName())
                .build()
        );
    }
    @AggregateIdentifier
    private String libraryId;

    private String name;

    private List<String> isbnBooks;

    //restoring aggregate state
    @EventSourcingHandler
    public void on(LibraryCreatedEvent event){
        this.libraryId = event.getLibraryId();
        this.name = event.getName();
        this.isbnBooks = new ArrayList<>();
    }

    @CommandHandler
    public void handles(AddBookCommand cmd) throws  Exception{
        Assert.notNull(cmd.getLibraryId(),"libraryId should be not null");
        Assert.notNull(cmd.getTitle(),"title should be not null");

    }
}
