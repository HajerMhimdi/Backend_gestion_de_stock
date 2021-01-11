package com.jdbc.demo.controller;

import com.jdbc.demo.dto.commande.CommandeAddDto;
import com.jdbc.demo.dto.commande.CommandeDto;
import com.jdbc.demo.service.ICommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CommandeController {

    @Autowired
    private ICommandeService commandeService;

    @GetMapping(value = "/commande-list")
    public List<CommandeDto> getAll() {
        return commandeService.getAll();}



    @PostMapping(value ="/new")

    public CommandeDto addNewCommande(@RequestBody CommandeAddDto commandeAddDto){
    return commandeService.addCommande(commandeAddDto);
    }

    @PostMapping(value = "/list")
    public Page<CommandeDto> getPageCommande(@RequestParam(value = "page", defaultValue = "0")
                                             int page, @RequestParam(value = "size", defaultValue = "5") int size){

        return commandeService.getAll(PageRequest.of(page, size));

    }

}




