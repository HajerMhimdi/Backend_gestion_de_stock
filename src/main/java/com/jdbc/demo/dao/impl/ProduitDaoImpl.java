package com.jdbc.demo.dao.impl;

import com.jdbc.demo.dao.IProduitDao;
import com.jdbc.demo.dao.entity.Produit;
import com.jdbc.demo.dao.repository.ProduitRepository;
import com.jdbc.demo.dto.produit.PrduitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Repository
public class ProduitDaoImpl implements IProduitDao {
    private final ProduitRepository produitRepository;

    @Autowired
    public ProduitDaoImpl(ProduitRepository produitRepository){
        this.produitRepository = produitRepository;
    }



    @Override
    public Boolean addProduit(Produit produit) {
        if(!produitRepository.existsById(produit.getCodeProduit())) {
            produitRepository.save(produit);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateProduit(Produit produit) {
        if(!produitRepository.existsById(produit.getCodeProduit())) {
            produitRepository.save(produit);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteProduit(String codeProduit) {
        if(produitRepository.existsById(codeProduit)) {
            produitRepository.deleteById(codeProduit);
            return true;
        }
        return false;
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Produit getProduitByCode(String codeProduit) {
        return produitRepository.findById(codeProduit).orElseThrow(() -> new EntityNotFoundException("Product with code: "+ codeProduit + "not found"));

    }


    @Override
    public Page<Produit> getPageProduits(Pageable pageable) {
        return produitRepository.findAll(pageable);
    }
}



