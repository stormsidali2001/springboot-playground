package com.stormsidali2001.test_project.entities;
import org.springframework.data.rest.core.config.Projection;


@Projection(name="p1", types={Client.class})
public interface ClientProjection {

    // @Value("#{target.idClient}")
    // public Long getIdClient();
    
    // @Value("#{target.clientDetails.description}")
    // public String getDescription();
    
    // @Value("#{target.addrese.ville}")
    // public String getCity();

    String getEmail();

    
}
