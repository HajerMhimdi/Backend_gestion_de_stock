package com.jdbc.demo.service;


import com.jdbc.demo.dto.produit.PrduitDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProduitService {



    Boolean addProduit(PrduitDto produitDto);


    Boolean updateProduit(PrduitDto produitDto);

    Boolean deleteProduit(String  codeProduit);

    List<PrduitDto> getAllProduits();

    PrduitDto getProduitByCode(String codeProduit);

    Page<PrduitDto> getPageProduits(Pageable pageable);
}
