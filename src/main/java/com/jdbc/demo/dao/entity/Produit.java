package com.jdbc.demo.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produit {

    @Id
    //@Column (unique = true, nullable = false)

    private String codeProduit;

    @Column(nullable = false,unique = true)
    private String nom;
    private double qteStock;
    private double prixVente;
    private float tva;

    //@OneToMany(mappedBy - "produit")
    //private List<LigneCommande> ligneCommandes;

}
