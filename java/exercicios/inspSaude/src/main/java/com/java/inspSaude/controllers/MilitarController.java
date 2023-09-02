package com.java.inspSaude.controllers;


import com.java.inspSaude.dto.MilitarDTO;
import com.java.inspSaude.reports.MilitarReport;
import com.java.inspSaude.services.DownloadService;
import com.java.inspSaude.services.MilitarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/militar")
@Api(value = "", tags = "Militar", description = "")
public class MilitarController {

    @Autowired
    private MilitarService militarService;

    @Autowired
    private DownloadService downloadService;

    @GetMapping("/buscar/id/{id}")
    public ResponseEntity buscarPorCep(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(militarService.buscarPorId(id));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/download/relatorio/{id}")
    @ApiOperation(value = "Downloads relatorio de militar por Id.", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    public ResponseEntity<byte[]> downloadPdf(@RequestParam Long id) {
        try {
            byte[] pdfBytes = downloadService.generatePdfFromApiData(id);

            // Defina o nome do arquivo para o download
            String filename = "dados_api.pdf";

            // Defina os cabeçalhos para a resposta HTTP
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", filename);

            return ResponseEntity.ok().headers(headers).body(pdfBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}