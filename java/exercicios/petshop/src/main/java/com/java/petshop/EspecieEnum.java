package com.java.petshop;

public enum EspecieEnum {

    CACHORRO("Cachorro"),
    GATO("Gato"),
    PASSARO("Pássaro"),
    OUTROS("Outros");

    private final String descricao;

    EspecieEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
