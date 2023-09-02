package com.java.projetoVendas.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.java.projetoVendas.models.dto.ItensVendaDTO;
import com.java.projetoVendas.models.dto.ProdutoDTO;
import com.java.projetoVendas.models.dto.VendaDTO;
import com.java.projetoVendas.report.VendaReport;
import com.java.projetoVendas.service.VendaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.util.List;

@RestController
@RequestMapping("/venda")
@Api(value = "", tags = "Venda", description = "")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping("/Salvar")
    @ApiOperation(value = "Salvar todas as Vendas.", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    public void salvarVenda(@RequestBody VendaDTO vendaDTO) {
        try {
            vendaService.salvarVenda(vendaDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/listar")
    @ApiOperation(value = "Listar todas as vendas", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    public List<VendaDTO> listarItens() {
        try {
            return vendaService.listarItens();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/listar/pdf")
    @ApiOperation(value = "Gerar lista de itens em PDF", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    public ResponseEntity<byte[]> gerarListaItensPDF() {
        try {
            List<ItensVendaDTO> itensVenda = vendaService.listarItensVenda();

            // Criação do documento PDF
            Document documento = new Document();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PdfWriter.getInstance(documento, outputStream);

            // Abertura do documento
            documento.open();

            // Adicionar conteúdo ao documento
            for (ItensVendaDTO venda : itensVenda) {
                Paragraph paragraph = new Paragraph();
                paragraph.add("Quem vendeu: " + venda.getVenda().getQuemVendeu() + "\n");
                paragraph.add("Quem comprou: " + venda.getVenda().getNomeCliente() + "\n");
                paragraph.add("Nome do produto: " + venda.getProduto().getNome() + "\n");
                paragraph.add("Valor do produto: " + venda.getProduto().getPrecoVenda() + "\n");
                paragraph.add("Quantidade: " + venda.getQuantidade() + "\n");
                paragraph.add("\n");

                documento.add(paragraph);
            }

            // Fechamento do documento
            documento.close();

            // Obtenção dos bytes do PDF
            byte[] pdfBytes = outputStream.toByteArray();

            // Definição dos cabeçalhos da resposta HTTP
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "itens_venda.pdf");

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(pdfBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}