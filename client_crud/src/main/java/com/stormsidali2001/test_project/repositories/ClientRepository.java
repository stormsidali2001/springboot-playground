package com.stormsidali2001.test_project.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.stormsidali2001.test_project.entities.Client;
import java.util.List;

@RepositoryRestResource
public interface ClientRepository  extends JpaRepository<Client, Long> {
    List<Client> findClientsByNom(String nom);

    @Query("select c.addrese.ville from Client c where c.idClient = :id")
    String findVilleById(@Param("id") Long id);

    @Query(value="select e.* from client e join compte c on e.id_client = c.client_id where c.login = :login", nativeQuery = true)
    Client findByLogin(@Param("login") String login);
    
}
