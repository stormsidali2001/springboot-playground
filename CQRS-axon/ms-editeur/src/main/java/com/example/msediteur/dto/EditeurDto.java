package com.example.msediteur.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder @Data @AllArgsConstructor @NoArgsConstructor
public class EditeurDto {
    private String editeurId;

    private String name;

    private String pays;
}
