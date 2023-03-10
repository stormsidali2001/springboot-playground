package com.example.coreapi.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder @NoArgsConstructor @AllArgsConstructor @Data
public class BookAddedEvent {
    private String libraryId;

    private String isbn;

    private String title;

    private String editeurId;
}
