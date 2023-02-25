package com.stormsidali2001.test_project.repositories;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.JpaRepository;
import com.stormsidali2001.test_project.entities.ClientDetails;

@RepositoryRestResource
public interface CLientDetailsRepository  extends JpaRepository<ClientDetails, Long> {
    
}
