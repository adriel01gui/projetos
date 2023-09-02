package com.java.exercicio_aula07.controllers;

import com.java.exercicio_aula07.models.dto.ProdutoDTO;
import com.java.exercicio_aula07.reports.ReportProduto;
import com.java.exercicio_aula07.reports.Teste;
import com.java.exercicio_aula07.services.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produto")
@Api(value = "", tags = "Produto", description = "")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/listar")
    @ApiOperation(value = "Listar todos os produtos.", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    public List<ProdutoDTO> listarTodos() {

        try {
            return produtoService.listarTodos();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/download/relatório/{id}")
    @ApiOperation(value = "Downloads relatorio de produtos.", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    public ResponseEntity downloadRelatorio(@PathVariable Integer id) {
        try {
            ProdutoDTO produtoDTO = produtoService.buscarPorId(id);

            byte[] relatorio = new ReportProduto(produtoDTO).createPDF();
            return new ResponseEntity(relatorio, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/download/lista-relatório/{id}")
    @ApiOperation(value = "Downloads relatorio de produtos.", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    public List<byte[]> gerarListaDePDF(List<ProdutoDTO> listaDeProdutos) {
        List<byte[]> listaDeBytesPDF = new ArrayList<>();

        for (ProdutoDTO produto : listaDeProdutos) {
            Teste teste = new Teste(produto);
            byte[] bytesPDF = teste.createPDF();
            listaDeBytesPDF.add(bytesPDF);
        }

        return listaDeBytesPDF;
    }


    @PostMapping("/salvar")
    @ApiOperation(value = "Salvar todos os produtos.", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    public void salvar(@RequestBody ProdutoDTO produtoDTO) {
        try {
            produtoService.salvar(produtoDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
