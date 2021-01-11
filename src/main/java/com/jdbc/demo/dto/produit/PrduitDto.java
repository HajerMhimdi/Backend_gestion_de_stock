package com.jdbc.demo.dto.produit;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data


public class PrduitDto {

    private String codeProduit;
    private String nom;
    private double qteStock;
    private double prixVente;
    private float tva;
}
