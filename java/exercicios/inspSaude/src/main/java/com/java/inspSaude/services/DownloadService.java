package com.java.inspSaude.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.java.inspSaude.dto.InspecaoDTO;
import com.java.inspSaude.dto.MilitarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;

@Service
public class DownloadService {

    @Autowired
    private InspecaoService inspecaoService;


    public byte[] generatePdfFromApiData(Long id) throws DocumentException, JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MilitarDTO> response = restTemplate.getForEntity("https://swapi.dev/api/people/" + id, MilitarDTO.class);
        MilitarDTO militarDTO = response.getBody();

        if (militarDTO != null && militarDTO.getName() != null) {
            // Criação do documento PDF
            Document document = new Document();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, outputStream);


            // Abertura do documento
            document.open();


            // Adicionar o conteúdo ao documento
            addTitle(document, militarDTO);
            addAttributes(document, militarDTO);


            // Fechar o documento
            document.close();

            return outputStream.toByteArray();
        } else {
            return null;
        }
    }

    private void addTitle(Document document, MilitarDTO militarDTO) throws DocumentException {
        Paragraph title = new Paragraph(militarDTO.getName(), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18));
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        document.add(Chunk.NEWLINE);
    }

    private void addAttributes(Document document, MilitarDTO militarDTO) throws DocumentException {
        // Adicionar os campos relevantes do objeto MilitarDTO no PDF
        document.add(new Paragraph("Nome: " + militarDTO.getName() + "\n"));
        document.add(new Paragraph("Altura: " + militarDTO.getHeight() + "cm" + "\n"));
        document.add(new Paragraph("Peso: " + militarDTO.getMass() + "kg" + "\n"));

        InspecaoDTO inspecaoDTO = militarDTO.getInspecaoDTO();
        if (inspecaoDTO != null) {
            document.add(new Paragraph("Inspeção:"));
            document.add(new Paragraph("Data da Inspeção: " + inspecaoDTO.getDataInspecao()));
            document.add(new Paragraph("Data da validade: " + inspecaoDTO.getValidade()));
            // Adicione outros atributos de inspecaoDTO que desejar
        } else {
            document.add(new Paragraph("Inspeção: N/A"));
        }

    }
}