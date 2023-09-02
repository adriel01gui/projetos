package com.java.aula06E.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
public enum DescricaoDisciplina {

    PORTUGUES("Portugues"),
    MATEMATICA("Matemática"),
    FISICA("Fisica"),
    PROGRAMAÇÃO1("Programação1"),
    PROGRAMAÇÃO2("Programação2");

    @Getter
    private String value;
}
