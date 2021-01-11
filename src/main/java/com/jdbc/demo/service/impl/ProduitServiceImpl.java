package com.jdbc.demo.service.impl;

import com.jdbc.demo.dao.IProduitDao;
import com.jdbc.demo.dao.entity.Client;
import com.jdbc.demo.dao.entity.Produit;
import com.jdbc.demo.dto.produit.PrduitDto;
import com.jdbc.demo.mapper.ProduitMapper;
import com.jdbc.demo.service.IProduitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImpl implements IProduitService {

    private final IProduitDao produitDao;
    private final ModelMapper mapper;
    private final ProduitMapper produitMapper;

    @Autowired
    public ProduitServiceImpl(IProduitDao produitDao, ModelMapper mapper, ProduitMapper produitMapper){
        this.produitDao = produitDao;
        this.mapper = mapper;
        this.produitMapper = produitMapper;
    }



    @Override
    public Boolean addProduit(PrduitDto produitDto) {
        return produitDao.addProduit(mapper.map(produitDto, Produit.class));
    }

    @Override
    public Boolean updateProduit(PrduitDto produitDto) {
        return produitDao.updateProduit(mapper.map(produitDto, Produit.class));
    }

    @Override
    public Boolean deleteProduit(String codeProduit) {
        return produitDao.deleteProduit(codeProduit);
    }

    @Override
    public List<PrduitDto> getAllProduits() {
        return produitMapper.listEntityToDto(produitDao.getAllProduits());
    }

    @Override
    public PrduitDto getProduitByCode(String codeProduit) {
        Produit produitEntity = produitDao.getProduitByCode(codeProduit);
        return mapper.map(produitEntity, PrduitDto.class);
    }

    @Override
    public Page<PrduitDto> getPageProduits(Pageable pageable) {
        return produitMapper.pageEntityToDto(produitDao.getPageProduits(pageable));
    }
}
