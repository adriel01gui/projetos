package com.java.petshop.entities.dto;

import com.java.petshop.EspecieEnum;
import lombok.Data;
import javax.persistence.Enumerated;

@Data
public class AnimalDTO {

    private String nome;
    @Enumerated
    private EspecieEnum especie;
    private String raca;
    private ClienteDTO cliente;
}
