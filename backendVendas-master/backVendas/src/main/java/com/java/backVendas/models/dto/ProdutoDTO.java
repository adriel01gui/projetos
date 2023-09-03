package com.java.backVendas.models.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ProdutoDTO {

    private String nome;
    private Double precoCompra;
    private Double precoVenda;
}
