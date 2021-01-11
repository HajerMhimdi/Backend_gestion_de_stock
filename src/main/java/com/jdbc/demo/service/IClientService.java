package com.jdbc.demo.service;

import com.jdbc.demo.dao.entity.Client;
import com.jdbc.demo.dto.AddClientDto;
import com.jdbc.demo.dto.ClientDto;

import java.util.List;


public interface IClientService {
    List<ClientDto> getAllClients();
    ClientDto add(AddClientDto client);

    boolean updateClient(Client client);

    boolean deleteById(Long id);

    boolean deleteByClient(Client client);

    Client findById(Long id);
}
