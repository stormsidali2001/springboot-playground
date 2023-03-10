package com.example.coreapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder @Data @AllArgsConstructor @NoArgsConstructor
public class BookDto {
    private String libraryId;
    private String isbn;
    private String title;
    private String editeurId;
}
