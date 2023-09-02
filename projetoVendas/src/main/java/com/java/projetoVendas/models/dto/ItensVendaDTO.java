package com.java.projetoVendas.models.dto;

import com.java.projetoVendas.models.entities.Produto;
import lombok.Data;

@Data
public class ItensVendaDTO {
    private ProdutoDTO produto;
    private VendaDTO venda;
    private Integer quantidade;


}