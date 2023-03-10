package com.example.mslibraryquery.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Table(name="book")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Book {
    @Id
    private String isbn;

    private String title;

    @ManyToOne
    private Library library;

    private String editeurId;

}
