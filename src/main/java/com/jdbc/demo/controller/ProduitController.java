package com.jdbc.demo.controller;

import com.jdbc.demo.dto.produit.PrduitDto;
import com.jdbc.demo.service.IProduitService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController

@RequestMapping
public class ProduitController {

    private final IProduitService produitService;
    public ProduitController(IProduitService produitService){
        this.produitService = produitService;
    }

    @PostMapping("/add")
    public  Boolean addProduit(@RequestBody PrduitDto prduitDto){
        return produitService.addProduit(prduitDto);
    }

    @PutMapping("/update")
    public Boolean updateProduit(@RequestBody PrduitDto prduitDto){
        return produitService.updateProduit(prduitDto);

    }

    @DeleteMapping("/delete")
    public Boolean deleteProduct(@RequestAttribute String codeProduit){
        return produitService.deleteProduit(codeProduit);
    }

    @GetMapping("/all")
    public List<PrduitDto> getAllProduit(){
        return produitService.getAllProduits();
    }

    @GetMapping("/page")
    public Page<PrduitDto> getProduitByPage(@RequestParam(value = "page", defaultValue = "0")
                                            int page, @RequestParam(value = "size", defaultValue = "5") int size) {
        return produitService.getPageProduits(PageRequest.of(page, size));
    }
}
