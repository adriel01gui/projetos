package com.java.petshop.entities.dto;

import com.java.petshop.entities.Venda;
import lombok.Data;

@Data
public class ItensVendaDTO {

    private ClienteDTO cliente;
    private VendaDTO venda;
    private ProdutoDTO produto;
    private Integer quantidade;
    private Double total;


}
