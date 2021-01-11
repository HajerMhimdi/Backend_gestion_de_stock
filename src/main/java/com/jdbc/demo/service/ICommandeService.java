package com.jdbc.demo.service;

import com.jdbc.demo.dto.ClientDto;
import com.jdbc.demo.dto.commande.CommandeAddDto;
import com.jdbc.demo.dto.commande.CommandeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICommandeService {
    CommandeDto addCommande(CommandeAddDto commandeAddDto);
    CommandeDto updateCommande (CommandeDto commandeDto);
    boolean deleteCommande(Long idCommande);
    CommandeDto getById (Long idCommande);
    List<CommandeDto> getAll();
    List<CommandeDto> getByClient (ClientDto clientDto);

    Page<CommandeDto> getAll(Pageable pageable);

}
