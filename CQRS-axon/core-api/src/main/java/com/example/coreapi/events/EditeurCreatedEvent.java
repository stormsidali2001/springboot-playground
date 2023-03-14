package com.example.coreapi.events;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder @Data @AllArgsConstructor @NoArgsConstructor
public class EditeurCreatedEvent {
    private String editeurId;

    private String name;

    private String pays;
}
