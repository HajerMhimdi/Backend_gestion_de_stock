package com.jdbc.demo.dao.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String tel;
    @Column(unique=true,nullable = false,length=100)
    private String mf;


}
