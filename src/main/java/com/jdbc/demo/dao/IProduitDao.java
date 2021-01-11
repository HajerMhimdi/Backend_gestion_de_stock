package com.jdbc.demo.dao;

import com.jdbc.demo.dao.entity.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProduitDao {



    Boolean addProduit(Produit produit);

    Boolean updateProduit(Produit produit);

    Boolean deleteProduit(String codeProduit);

    List<Produit> getAllProduits();

    Produit getProduitByCode(String codeProduit);

    Page<Produit> getPageProduits(Pageable pageable);




}
