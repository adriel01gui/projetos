package com.java.backVendas.models.dto;

import lombok.Data;

import com.java.backVendas.enums.CategoriaEnum;

@Data
public class ProdutoDTO {

    private String nome;
    private Double precoCompra;
    private CategoriaEnum categoria;
    private Double precoVenda;
}