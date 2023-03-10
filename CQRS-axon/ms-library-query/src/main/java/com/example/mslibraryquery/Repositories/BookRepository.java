package com.example.mslibraryquery.Repositories;

import com.example.mslibraryquery.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,String> {
}
