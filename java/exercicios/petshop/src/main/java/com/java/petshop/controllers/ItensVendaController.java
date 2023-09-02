package com.java.petshop.controllers;

import com.java.petshop.entities.dto.ItensVendaDTO;
import com.java.petshop.services.ItensVendaService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItensVendaController {

    @Autowired
    private ItensVendaService itensVendaService;

    @GetMapping("/listar")
    public List<ItensVendaDTO> listarTodos(){
        try {
            return itensVendaService.listarTodos();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/gerar/relatorio")
    public ResponseEntity gerarRelatorio() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "petShop.pdf");
        return ResponseEntity.ok().headers(headers).body(itensVendaService.gerarRelatorio());
    }
}
