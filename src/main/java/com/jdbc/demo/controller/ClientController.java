package com.jdbc.demo.controller;


import com.jdbc.demo.dao.entity.Client;
import com.jdbc.demo.dto.AddClientDto;
import com.jdbc.demo.dto.ClientDto;
import com.jdbc.demo.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    IClientService clientService;

    @GetMapping("/")
    public List<ClientDto> getClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/find")
    public Client getClient(@RequestParam Long id){
        return clientService.findById(id);

    }

    @PostMapping("/add")
    public ClientDto addClient(@RequestParam AddClientDto client){
        return clientService.add(client);



    }
    @DeleteMapping("/remove")
    public boolean deleteClient(@RequestParam Long id){
        return clientService.deleteById(id);
    }
    @PutMapping("/update")
    public boolean updateClient(@RequestBody Client client){
        return clientService.updateClient(client);
    }


}
