package com.java.backVendas.services;

import com.java.backVendas.models.Produto;
import com.java.backVendas.models.dto.ProdutoDTO;
import com.java.backVendas.repositories.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    ModelMapper modelMapper = new ModelMapper();

    public List<ProdutoDTO> listarTodos() throws Exception {
        List<ProdutoDTO> produtos = repository.findAll().stream().map(produto -> {
            ProdutoDTO produtoDTO = modelMapper.map(produto, ProdutoDTO.class);
            return produtoDTO;
        }).collect(Collectors.toList());

        return produtos;
    }

    public void atualizarProduto(Long id, ProdutoDTO produtoDTO) throws Exception {
        Produto produtoExistente = repository.findById(id).orElseThrow(() -> new Exception("Produto não encontrado"));

        // Atualize os campos do produto existente com os dados do DTO
        produtoExistente.setNome(produtoDTO.getNome());
        produtoExistente.setPrecoVenda(produtoDTO.getPrecoCompra());

        // Salve o produto atualizado no repositório
        repository.save(produtoExistente);
    }

    public void salvar(ProdutoDTO produtoDTO) throws Exception {
        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        repository.save(produto);
    }

    public void excluir(Long id) throws Exception {
        Produto produto = repository.findById(id).get();
        if (produto != null) {
            repository.delete(produto);
        }
    }

    public ProdutoDTO buscarPorId(Long id) throws Exception {
        ProdutoDTO produtoDTO = modelMapper.map(repository.findById(id).get(), ProdutoDTO.class);
        return produtoDTO;
    }
}