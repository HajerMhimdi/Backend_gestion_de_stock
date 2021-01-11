package com.jdbc.demo.service.impl;

import com.jdbc.demo.dao.IClientDao;
import com.jdbc.demo.dao.entity.Client;
import com.jdbc.demo.dto.AddClientDto;
import com.jdbc.demo.dto.ClientDto;
import com.jdbc.demo.mapper.ClientMapper;
import com.jdbc.demo.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

@Service
public class ClientServiceImpl implements IClientService {
    @Autowired
    private IClientDao clientDao;
    @Override
    public List<ClientDto> getAllClients() {
        return ClientMapper.listEntityToDto(clientDao.getAllClient());
    }

    @Override
    public ClientDto add(AddClientDto addClientDto) {
        Client client = ClientMapper.dtoToEntity(addClientDto);
        Client entity = clientDao.addClient(client);
        return ClientMapper.entityToDto(entity);
    }

    @Override
    public boolean updateClient(Client client) {
        return clientDao.updateClient(client);
    }

    @Override
    public boolean deleteById(Long id) {
        return clientDao.deleteClient(id);
    }

    @Override
    public boolean deleteByClient(Client client) {
        return clientDao.deleteClient(client);
    }

    @Override
    public Client findById(Long id) {
        Optional<Client> clientOptional = clientDao.findById(id); // help us to find exceptions
        return clientOptional.orElseThrow(() ->
                new EntityNotFoundException("Client not found with id: " +id));
    }
}
