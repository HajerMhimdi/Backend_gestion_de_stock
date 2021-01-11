package com.jdbc.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddClientDto {

    private String nom;
    private String tel;
    private String mf;
}
