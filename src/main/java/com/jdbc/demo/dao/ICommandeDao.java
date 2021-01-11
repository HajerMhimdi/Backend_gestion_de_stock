package com.jdbc.demo.dao;

import com.jdbc.demo.dao.entity.Client;
import com.jdbc.demo.dao.entity.Commande;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface ICommandeDao {
    Commande addCommande(Commande commande);
    Commande updateCommande(Commande Commande);
    boolean deleteCommande(Long idCommande);
    Commande getById(Long idCommande);
    List<Commande> getAll();
    List<Commande> getByClient(Client client);
    Page<Commande> getAll (Pageable pageable);
}
