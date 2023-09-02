package com.java.projetoVendas.service;

import com.java.projetoVendas.models.dto.ItensVendaDTO;
import com.java.projetoVendas.models.dto.ProdutoDTO;
import com.java.projetoVendas.models.entities.Venda;
import com.java.projetoVendas.models.dto.VendaDTO;
import com.java.projetoVendas.repositories.ItensVendaRepository;
import com.java.projetoVendas.repositories.ProdutoRepository;
import com.java.projetoVendas.repositories.VendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ItensVendaRepository itensVendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    private ModelMapper modelMapper = new ModelMapper();


    public void salvarVenda(VendaDTO vendaDTO) throws Exception {
        Venda venda = modelMapper.map(vendaDTO, Venda.class);
        vendaRepository.save(venda);
    }

    public List<VendaDTO> listarItens() throws Exception {
        List<VendaDTO> vendas = vendaRepository.findAll().stream().map(venda -> {
            VendaDTO vendaDTO = modelMapper.map(venda, VendaDTO.class);
            vendaDTO.setQuemVendeu(vendaDTO.getQuemVendeu());
            return vendaDTO;
        }).collect(Collectors.toList());
        return vendas;
    }


    public ProdutoDTO buscarPorIdProduto(Long id) throws Exception {
        ProdutoDTO produtoDTO = modelMapper.map(produtoRepository.findById(id).get(), ProdutoDTO.class);
        return produtoDTO;
    }

    public List<ItensVendaDTO> listarItensVenda() throws Exception {
        List<ItensVendaDTO> itensVendaDTOList = itensVendaRepository.findAll().stream().map(itensVenda -> {
            ItensVendaDTO itensVendaDTO = modelMapper.map(itensVenda, ItensVendaDTO.class);
            return itensVendaDTO;
        }).collect(Collectors.toList());
        return itensVendaDTOList;
    }

}