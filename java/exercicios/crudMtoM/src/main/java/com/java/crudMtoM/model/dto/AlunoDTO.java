package com.java.crudMtoM.model.dto;


import lombok.Data;

import java.util.List;

@Data
public class AlunoDTO {


    private String nome;
    private List<DisciplinaDTO> disciplinasDTO;
}
