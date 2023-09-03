package com.java.backVendas.models.dto;

import lombok.Data;

@Data
public class ItensVendaDTO {

    private ProdutoDTO produto;
    private VendaDTO venda;
    private Double quantidade;
}
