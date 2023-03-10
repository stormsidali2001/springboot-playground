package com.example.mslibraryquery.Entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity @Table(name = "library")
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class Library {
    @Id
    private String libraryId;

    private String name;

    @OneToMany(mappedBy = "library")
    private Collection<Book> books;

}
