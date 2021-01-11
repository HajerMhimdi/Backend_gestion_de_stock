package com.jdbc.demo.dao.repository;

import com.jdbc.demo.dao.entity.Client;
import com.jdbc.demo.dao.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeRepository extends JpaRepository <Commande, Long> {
    List<Commande> findByClient(Client client);
}
