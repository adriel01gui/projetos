package com.java.backVendas.enums;

public enum CategoriaEnum {
    BEBIDA("Bebida"),
    COMIDA("Comida");

    private final String descricao;

    CategoriaEnum(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
