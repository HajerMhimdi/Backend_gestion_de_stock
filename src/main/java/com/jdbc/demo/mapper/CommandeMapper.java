package com.jdbc.demo.mapper;

import com.jdbc.demo.dao.entity.Commande;
import com.jdbc.demo.dto.ClientDto;
import com.jdbc.demo.dto.commande.CommandeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CommandeMapper {
    @Autowired
    private ModelMapper mapper;

    public List<CommandeDto> entutyListToDo(List<Commande> commandesListEntity){
        return commandesListEntity.stream().map(commande -> commandeEntityToDto(commande)).collect(Collectors.toList());

    }
    public CommandeDto commandeEntityToDto(Commande commande){
        //map commande from entuty to Dto
        CommandeDto commandeDto = mapper.map(commande, CommandeDto.class);
        //map client commde get cclient from entity to dto
        ClientDto clientDto = mapper.map(commande.getClient(), ClientDto.class);
        commandeDto.setClientDto(clientDto);
        return commandeDto;
    }
    public CommandeDto entityToDto(Commande entity){
        return mapper.map(entity, CommandeDto.class);
    }
    public Page<CommandeDto> pageEntityToDto(Page<Commande> pageOfEntity){
        Page<CommandeDto> commandeDtoPage = pageOfEntity.map(new Function<Commande, CommandeDto>() {
            @Override
            public CommandeDto apply(Commande commande) {
               return mapper.map(commande, CommandeDto.class);
            }
        });
        return commandeDtoPage;
    }
}
