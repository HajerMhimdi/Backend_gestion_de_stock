package com.jdbc.demo.dao.impl;

import com.jdbc.demo.dao.IClientDao;
import com.jdbc.demo.dao.entity.Client;
import com.jdbc.demo.dao.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
//imlementation interface dao
public class ClientDaoImpl implements IClientDao {

    @Autowired //injection dependence
    ClientRepository clientRepository;
    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public boolean updateClient(Client client) {
        if (clientRepository.save(client)!=null)
            return true;
            else
                return false;
    }

    @Override
    public boolean deleteClient(Long id) {
        if (clientRepository.existsById(id)){
            clientRepository.deleteById(id);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteClient(Client client) {
        if (clientRepository.existsById(client.getId())){
            clientRepository.delete(client);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }
}
