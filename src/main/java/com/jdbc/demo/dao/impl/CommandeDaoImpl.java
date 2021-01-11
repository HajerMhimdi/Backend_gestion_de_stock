package com.jdbc.demo.dao.impl;

import com.jdbc.demo.dao.ICommandeDao;
import com.jdbc.demo.dao.entity.Client;
import com.jdbc.demo.dao.entity.Commande;
import com.jdbc.demo.dao.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public class CommandeDaoImpl implements ICommandeDao {
    @Autowired
    private CommandeRepository commandeRepository;

    @Override
    public Commande addCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Commande updateCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public boolean deleteCommande(Long idCommande) {
        if(commandeRepository.existsById(idCommande)){
            commandeRepository.deleteById(idCommande);
            return true;
        }
        return false;
    }

    @Override
    public Commande getById(Long idCommande) {
        Optional<Commande> optional = commandeRepository.findById(idCommande);
        return optional.orElseThrow(()-> new IllegalArgumentException("Commande"));
    }

    @Override
    public List<Commande> getAll() {
        return commandeRepository.findAll();
    }

    @Override
    public List<Commande> getByClient(Client client) {
        return commandeRepository.findByClient(client);
    }


    @Override
    public Page<Commande> getAll(Pageable pageable) {
        return commandeRepository.findAll((org.springframework.data.domain.Pageable) pageable);
    }
}
