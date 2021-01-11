package com.jdbc.demo.service.impl;

import com.jdbc.demo.dao.IClientDao;
import com.jdbc.demo.dao.ICommandeDao;
import com.jdbc.demo.dao.entity.Client;
import com.jdbc.demo.dao.entity.Commande;
import com.jdbc.demo.dto.ClientDto;
import com.jdbc.demo.dto.commande.CommandeAddDto;
import com.jdbc.demo.dto.commande.CommandeDto;
import com.jdbc.demo.mapper.CommandeMapper;
import com.jdbc.demo.service.ICommandeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.management.OperatingSystemMXBean;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeServiceImpl implements ICommandeService {

    @Autowired
    CommandeMapper commandeMapper;

    @Autowired
    private ICommandeDao commandeDao;

    @Autowired
    private IClientDao clientDao;

    @Autowired
    private ModelMapper mapper;

    @Override
    public CommandeDto addCommande(CommandeAddDto commandeAddDto) {
        Optional<Client> clientEntity = clientDao.findById(commandeAddDto.getClientDto().getId());
        if (clientEntity.isPresent()) {
            Commande commandeEntity = mapper.map(commandeAddDto, Commande.class);
            commandeEntity.setClient(clientEntity.get());

            Commande commandeEntityWithId = commandeDao.addCommande(commandeEntity);
            CommandeDto commandeDto = mapper.map(commandeEntityWithId, CommandeDto.class);
            commandeDto.setClientDto(mapper.map(commandeEntityWithId.getClient(), ClientDto.class));
            return commandeDto;
        }
        return null;
    }


    @Override
    public CommandeDto updateCommande(CommandeDto commandeDto) {
        Optional<Client> clientEntity = clientDao.findById(commandeDto.getClientDto().getId());
        Commande commandeEntity = commandeDao.getById(commandeDto.getId());
        if(commandeEntity != null && clientEntity.isPresent()){
            Commande commandeMapEntity = mapper.map(commandeDto, Commande.class);
            commandeMapEntity.setClient(clientEntity.get());
            Commande commandeEntityWithId = commandeDao.updateCommande(commandeMapEntity);
            CommandeDto cmdDto = mapper.map(commandeEntityWithId, CommandeDto.class);
            return cmdDto;
        }
        return null;
    }

    @Override
    public boolean deleteCommande(Long idCommande) {
        return commandeDao.deleteCommande(idCommande);
    }

    @Override
    public CommandeDto getById(Long idCommande) {
        return mapper.map(commandeDao.getById(idCommande), CommandeDto.class);
    }

    @Override
    public List<CommandeDto> getAll() {
        return commandeMapper.entutyListToDo(commandeDao.getAll());
    }

    @Override
    public List<CommandeDto> getByClient(ClientDto clientDto) {
        return null;
    }

    @Override
    public Page<CommandeDto> getAll(Pageable pageable) {
        return commandeMapper.pageEntityToDto(commandeDao.getAll((java.awt.print.Pageable) pageable));
    }
}
