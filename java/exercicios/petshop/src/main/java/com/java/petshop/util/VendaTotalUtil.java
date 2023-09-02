package com.java.petshop.util;

import com.java.petshop.entities.dto.ItensVendaDTO;

import java.util.List;

public class VendaTotalUtil {

    public static double calcularTotalVenda(List<ItensVendaDTO> itensVenda) {
        double totalVenda = 0;

        for (ItensVendaDTO item : itensVenda) {
            double valorItem = item.getProduto().getPreco() * item.getQuantidade();
            totalVenda += valorItem;
        }

        return totalVenda;
    }
}
