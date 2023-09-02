package com.java.projetoVendas.models.dto;

import lombok.Data;

@Data
public class ProdutoDTO {
    private String nome;
    private String categoria;
    private Double precoCompra;
    private Double precoVenda;
}