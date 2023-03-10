package com.example.coreapi.commands;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder @Data @NoArgsConstructor @AllArgsConstructor
public class RemoveBookCommand {
    @TargetAggregateIdentifier
    private String libraryId;

    private String isbn;
}
