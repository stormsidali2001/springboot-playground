package com.example.msserver.Repositories;

import com.example.msserver.Entities.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ServerRepository extends JpaRepository<Server,Long> {
}
