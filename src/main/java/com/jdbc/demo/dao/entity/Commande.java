package com.jdbc.demo.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Data
@Entity
public class Commande {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime date;
    private double totalAmount;

    @ManyToOne
//    @JoinColumn(name = "")
    private Client client;
}
