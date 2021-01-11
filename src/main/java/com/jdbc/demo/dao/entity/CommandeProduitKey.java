package com.jdbc.demo.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CommandeProduitKey implements Serializable {

    //@Column(name = "commande_id")
    private Long commandeId;

    //@Column (name = "code_produit")
    private String codeProduit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CommandeProduitKey that = (CommandeProduitKey) o;

        if (commandeId != null ? !commandeId.equals(that.commandeId) : that.commandeId != null) return false;
        return codeProduit != null ? codeProduit.equals(that.codeProduit) : that.codeProduit == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (commandeId != null ? commandeId.hashCode() : 0);
        result = 31 * result + (codeProduit != null ? codeProduit.hashCode() : 0);
        return result;
    }
}
