package com.java.aula06E.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum DescricaoCurso {

    COMPUTACAO("Computação"),
    ENGENHARIA("Engenharia"),
    LETRAS("Letras");

    @Getter
    private String value;
}
