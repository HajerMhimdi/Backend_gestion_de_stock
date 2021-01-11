package com.jdbc.demo.dao;

import com.jdbc.demo.dao.entity.Client;

import java.util.List;
import java.util.Optional;

public interface IClientDao {

    List<Client> getAllClient();

    Client addClient(Client client);

    boolean updateClient(Client client);

    boolean deleteClient(Long id);

    boolean deleteClient(Client client);

    Optional<Client> findById(Long id);

}
