package com.java.projetoVendas.models.dto;


public class VendaDTO {
    private String quemVendeu;
    private String nomeCliente;

    public String getQuemVendeu() {
        return quemVendeu;
    }

    public void setQuemVendeu(String quemVendeu) {
        this.quemVendeu = quemVendeu;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}
