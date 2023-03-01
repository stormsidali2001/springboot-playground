package com.example.msscolarity.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name="detail_etudiant",types = Etudiant.class)
public interface DetailEtudiantProjection {
    @Value("#{target.nom}")
    public String getNom();
    @Value("#{target.promo}")
    public String getPromo();
    @Value("#{target.dateInscription}")
    public Date getDateInscription();
    @Value("#{target.etablissement.nom}")
    public String getNomEtablissement();

}
