package com.example.msediteur.repositories;

import com.example.msediteur.storedAggregate.Editeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditeurRepository extends JpaRepository<Editeur,String> {

}
