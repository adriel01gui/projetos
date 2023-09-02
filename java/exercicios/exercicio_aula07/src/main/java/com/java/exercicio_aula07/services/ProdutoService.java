package com.java.exercicio_aula07.services;

import com.java.exercicio_aula07.models.Produto;
import com.java.exercicio_aula07.models.dto.ProdutoDTO;
import com.java.exercicio_aula07.repositories.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public List<ProdutoDTO> listarTodos() throws Exception {
        List<ProdutoDTO> produtos = produtoRepository.findAll().stream().map(produto -> {
            ProdutoDTO produtoDTO = modelMapper.map(produto, ProdutoDTO.class);
            return produtoDTO;
        }).collect(Collectors.toList());

        return produtos;
    }

    public void salvar(ProdutoDTO produtoDTO) throws Exception {
        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        produtoRepository.save(produto);
    }

    public void atualizar(ProdutoDTO produtoDTO) throws Exception {
        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        produtoRepository.save(produto);
    }

    public void excluir(Integer id) throws Exception {
        Produto produto = produtoRepository.findById(id).get();
        if (produto != null) {
            produtoRepository.delete(produto);
        }
    }

    public ProdutoDTO buscarPorId(Integer id) throws Exception {
        ProdutoDTO produtoDTO = modelMapper.map(produtoRepository.findById(id).get(), ProdutoDTO.class);
        return produtoDTO;
    }

}