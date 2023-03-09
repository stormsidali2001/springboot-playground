package com.example.coreapi.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder @Data @NoArgsConstructor @AllArgsConstructor
public class LibraryDto {
    private String libraryId;

    private String name;
}
