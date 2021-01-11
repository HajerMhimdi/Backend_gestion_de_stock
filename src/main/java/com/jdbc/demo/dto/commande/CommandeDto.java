package com.jdbc.demo.dto.commande;

import com.jdbc.demo.dto.ClientDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommandeDto {
    private Long id;
    private LocalDateTime date;
    private double totalAmount;
    private ClientDto clientDto;

}
