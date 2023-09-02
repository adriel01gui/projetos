package com.java.petshop.services;

import com.java.petshop.entities.dto.ItensVendaDTO;
import com.java.petshop.report.ItensVendaReport;
import com.java.petshop.repositories.ItensVendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItensVendaService {

    @Autowired
    private ItensVendaRepository repository;

    ModelMapper modelMapper = new ModelMapper();

    public List<ItensVendaDTO> listarTodos()throws Exception{
        List<ItensVendaDTO> itens = repository.findAll().stream().map(item -> {
            ItensVendaDTO itensVendaDTO = modelMapper.map(item,ItensVendaDTO.class);
            return itensVendaDTO;
        }).collect(Collectors.toList());
        return itens;
    }

    public byte[] gerarRelatorio() throws Exception {
        return new ItensVendaReport(listarTodos()).createPDF();
    }

    public double calcularTotalVenda(List<ItensVendaDTO> itensVenda) {
        double totalVenda = 0;

        for (ItensVendaDTO item : itensVenda) {
            double valorItem = item.getProduto().getPreco() * item.getQuantidade();
            totalVenda += valorItem;
        }

        return totalVenda;
    }

}
