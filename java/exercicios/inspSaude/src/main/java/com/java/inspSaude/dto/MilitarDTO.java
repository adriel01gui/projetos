package com.java.inspSaude.dto;

import lombok.Data;

import java.util.List;

@Data
public class MilitarDTO {

    private Long id;
    private String name;
    private String height;
    private Double mass;
    private String photoUrl;

    private InspecaoDTO inspecaoDTO;
}