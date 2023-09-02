package com.java.exercicio06.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MilitarDTO {

    private String nome;
    private Date dataNascimento;
    private String nomeGuerra;
    private List<PostoGraduacaoDTO> itens;

}
