package com.example.mslibraryquery.projection;

import com.example.coreapi.events.BookAddedEvent;
import com.example.coreapi.events.BookRemovedEvent;
import com.example.coreapi.events.LibraryCreatedEvent;
import com.example.mslibraryquery.Entities.Book;
import com.example.mslibraryquery.Entities.Library;
import com.example.mslibraryquery.Repositories.BookRepository;
import com.example.mslibraryquery.Repositories.LibraryRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryProjection {
    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    BookRepository bookRepository;

    @EventHandler
    public void addLibrary(LibraryCreatedEvent event){
        libraryRepository.save(
                Library.builder()
                        .libraryId(event.getLibraryId())
                        .name(event.getName())
                        .build()
        );

    }

    @EventHandler
    public void addBook(BookAddedEvent event){
        Library lb = libraryRepository.findById(event.getLibraryId()).get();
        bookRepository.save(
                Book.builder()
                        .isbn(event.getIsbn())
                        .title(event.getTitle())
                        .library(lb)
                        .editeurId(event.getEditeurId())
                        .build()
        );
    }

    @EventHandler
    public void removeBook(BookRemovedEvent event){
        bookRepository.deleteById(event.getIsbn());
    }
}
