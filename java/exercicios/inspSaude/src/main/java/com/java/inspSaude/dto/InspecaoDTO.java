package com.java.inspSaude.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class InspecaoDTO {

    private LocalDate dataInspecao;
    private LocalDate validade;

    private MilitarDTO militarDTO;

}