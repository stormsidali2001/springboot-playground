package com.example.mscommandlibrary.aggregate;

import com.example.coreapi.commands.AddBookCommand;
import com.example.coreapi.commands.LibraryCreationCommand;
import com.example.coreapi.commands.RemoveBookCommand;
import com.example.coreapi.events.BookAddedEvent;
import com.example.coreapi.events.BookRemovedEvent;
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


    @AggregateIdentifier
    private String libraryId;

    private String name;

    private List<String> isbnBooks;

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
        Assert.notNull(cmd.getIsbn(),"isbn should be not null");
        Assert.notNull(cmd.getTitle(),"title should be not null");

        if(this.isbnBooks.contains(cmd.getIsbn())){
            throw new Exception("Book must be unique");
        }
        AggregateLifecycle.apply(
                BookAddedEvent.builder()
                        .title(cmd.getTitle())
                        .libraryId(cmd.getLibraryId())
                        .editeurId(cmd.getEditeurId())
                        .isbn(cmd.getIsbn())
                .build()
        );
    }
    @EventSourcingHandler
    public void on(BookAddedEvent event){
        this.isbnBooks.add(event.getIsbn());
    }

    @CommandHandler
    public void handler(RemoveBookCommand cmd) throws  Exception{
        Assert.notNull(cmd.getIsbn(),"isbn can't be null");
        Assert.notNull(cmd.getLibraryId(),"libraryId should be not null");
        if(!this.isbnBooks.contains(cmd.getIsbn())){
            throw new Exception("Book isbn must exist");
        }
        //progpagate the event
        AggregateLifecycle.apply(
                BookRemovedEvent.builder()
                        .libraryId(cmd.getLibraryId())
                        .isbn(cmd.getIsbn())
                        .build()
        );

    }

    @EventSourcingHandler
    public void on( BookRemovedEvent event){
        this.isbnBooks.remove(event.getIsbn());
    }
}
