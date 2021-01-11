package com.jdbc.demo.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Entity
public class LigneCommande {
    @EmbeddedId
    private CommandeProduitKey id;

    @ManyToOne
    @MapsId("commandeId")
    @JoinColumn(name = "commande_id")
    private Commande commande;

    @ManyToOne
    @MapsId("codeProduit")
    @JoinColumn(name = "code_produit")
    private Produit produit;
    private double prixAchat;
    private float tva;
    private double qte;

}
