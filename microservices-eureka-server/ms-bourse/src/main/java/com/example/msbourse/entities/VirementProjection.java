package com.example.msbourse.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "virement",types = Virement.class)
public interface VirementProjection {
    @Value("#{target.idVirement}")
    public Long getIdVirement();

    @Value("#{target.dateVirement}")
    public Date getDateVirement();

    @Value("#{target.etudiant.nCompteCcp}")
    public Long getNCompteCcp();

}
