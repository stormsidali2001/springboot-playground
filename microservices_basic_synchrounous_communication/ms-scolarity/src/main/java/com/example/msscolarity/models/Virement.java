package com.example.msscolarity.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data @NoArgsConstructor @AllArgsConstructor
public class Virement {
    private Long idVirement;
    private Date dateVirement;

    private Long nCompteCcp;
}
