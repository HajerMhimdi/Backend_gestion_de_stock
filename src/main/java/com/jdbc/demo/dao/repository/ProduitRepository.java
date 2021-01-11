package com.jdbc.demo.dao.repository;

import com.jdbc.demo.dao.entity.Produit;
import com.jdbc.demo.dto.produit.PrduitDto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface ProduitRepository extends JpaRepository<Produit, String> {

}
