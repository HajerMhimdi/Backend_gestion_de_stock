package com.jdbc.demo.mapper;

import com.jdbc.demo.dao.entity.Client;
import com.jdbc.demo.dto.AddClientDto;
import com.jdbc.demo.dto.ClientDto;

import java.util.List;
import java.util.stream.Collectors;

public class ClientMapper {
    public static ClientDto entityToDto (Client entity){
        return ClientDto.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .tel(entity.getTel())
                .build();
    }

    public static Client dtoToEntity (ClientDto dto){

        //Client client = new Client();
        return Client.builder()
                .id(dto.getId())
                .tel(dto.getTel())
                .nom(dto.getNom())
                .build();



    }
    public static Client dtoToEntity(AddClientDto dto){
        return Client.builder()
                .tel(dto.getTel())
                .nom(dto.getNom())
                .mf(dto.getMf())
                .build();
    }

    public static List<ClientDto> listEntityToDto (List<Client>clientsList){
        return clientsList.stream().map(client -> entityToDto(client))
                .collect(Collectors.toList());
    }
}
