package com.jdbc.demo.mapper;

import com.jdbc.demo.dao.entity.Commande;
import com.jdbc.demo.dao.entity.Produit;
import com.jdbc.demo.dto.ClientDto;
import com.jdbc.demo.dto.commande.CommandeDto;
import com.jdbc.demo.dto.produit.PrduitDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ProduitMapper {
    @Autowired
    private ModelMapper mapper;

    public List<PrduitDto> listEntityToDto(List<Produit> Entitylist){
        return Entitylist.stream().map(produit -> mapper.map(produit, PrduitDto.class)).collect(Collectors.toList());
    }
    public Page<PrduitDto> pageEntityToDto (Page<Produit> entityProduits){
        Page<PrduitDto> prduitDtoPage = entityProduits.map(new Function<Produit, PrduitDto>() {
            @Override
            public PrduitDto apply(Produit produit) {
                return mapper.map(produit, PrduitDto.class);
            }
        });
        //map to from entity to Dto

        return prduitDtoPage;}

    }


