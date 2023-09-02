package com.java.exercicio_aula07.models.dto;

import lombok.Data;

@Data
public class ProdutoDTO {

    private Integer id;
    private String nome;
    private Double preco;
    private Boolean situacao;
}
