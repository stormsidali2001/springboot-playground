package com.example.mslibraryquery.Repositories;

import com.example.mslibraryquery.Entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository  extends JpaRepository<Library,String> {
}
