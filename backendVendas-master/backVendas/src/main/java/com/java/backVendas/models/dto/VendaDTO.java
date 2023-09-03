package com.java.backVendas.models.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class VendaDTO {

    private String quemVendeu;
    private String nomeCliente;
}
