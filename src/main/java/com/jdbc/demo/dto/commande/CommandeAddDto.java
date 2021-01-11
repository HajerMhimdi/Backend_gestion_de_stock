package com.jdbc.demo.dto.commande;

import com.jdbc.demo.dto.ClientDto;
import lombok.*;

import java.time.LocalDateTime;

@Data
public class CommandeAddDto {

    private LocalDateTime date;
    private double totalAmount;
    private ClientDto clientDto;
}
