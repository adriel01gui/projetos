package com.java.petshop.entities.dto;

import lombok.Data;

import java.util.Date;

@Data
public class VendaDTO {

    private String quemVendeu;
    private ClienteDTO clienteDTO;
    private Date dt_venda;
}
