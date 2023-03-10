package com.example.mscommandlibrary.controller;


import com.example.coreapi.commands.AddBookCommand;
import com.example.coreapi.commands.LibraryCreationCommand;
import com.example.coreapi.commands.RemoveBookCommand;
import com.example.coreapi.dto.BookDto;
import com.example.coreapi.dto.LibraryDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("command")
public class CommandController {
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping("library")
    public CompletableFuture<String>  createLibrary(@RequestBody LibraryDto library){
        return this.commandGateway.send(
                LibraryCreationCommand.builder()
                        .libraryId(library.getLibraryId())
                        .name(library.getName())
                        .build()
        );
    }
    @PostMapping("library/{libraryId}/book")
    public CompletableFuture<String> createBook(@RequestBody BookDto book, @PathVariable("libraryId") String libraryId){
        return this.commandGateway.send(
                AddBookCommand.builder()
                        .libraryId(libraryId)
                        .title(book.getTitle())
                        .isbn(book.getIsbn())
                        .editeurId(book.getEditeurId())
                        .build()
        );
    }
    @DeleteMapping("library/{libraryId}/book/{isbn}")
    public CompletableFuture<String> deleteBook(@PathVariable("libraryId") String libraryId , @PathVariable("isbn") String isbn){
        return this.commandGateway.send(
                RemoveBookCommand.builder()
                        .libraryId(libraryId)
                        .isbn(isbn)
                        .build()
        );
    }

}
