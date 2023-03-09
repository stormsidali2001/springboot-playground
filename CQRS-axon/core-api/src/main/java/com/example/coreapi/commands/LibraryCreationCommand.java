package com.example.coreapi.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class LibraryCreationCommand {
    @TargetAggregateIdentifier
    private String libraryId;
    private String name;
}
