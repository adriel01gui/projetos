package com.java.inspSaude.reports;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.java.inspSaude.dto.MilitarDTO;

import java.io.ByteArrayOutputStream;

public class MilitarReport {

    protected static Font FONT_TITULO = new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.BOLD);
    private MilitarDTO militarDTO;

    public MilitarReport(MilitarDTO militarDTO) {
        this.militarDTO = militarDTO;
    }

    public byte[] createPDF() {
        try {
            Document documento = new Document(PageSize.A4);

            documento.setMargins(20, 20, 50, 20);
            documento.addCreationDate();
            documento.addAuthor("Adriel");

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            PdfWriter pdfWriter = PdfWriter.getInstance(documento, stream);

            documento.open();

            Paragraph paragraph = new Paragraph();
            Phrase titulo = new Phrase("Relatorio de Militares ", FONT_TITULO);
            paragraph.add(titulo);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            paragraph.setSpacingAfter(20);

            Paragraph dadosMilitar = new Paragraph();
            dadosMilitar.add("Nome: " + militarDTO.getName() + "\n");
            dadosMilitar.add("Altura: " + militarDTO.getHeight() + "\n");
            dadosMilitar.add("Peso: " + militarDTO.getMass() + "\n");
            dadosMilitar.setAlignment(Element.ALIGN_LEFT);
            paragraph.setSpacingAfter(15);

            Image foto = Image.getInstance(getClass().getResource("/static/militar.png"));
            foto.scaleAbsolute(80f, 80f);
            foto.setAlignment(Element.ALIGN_CENTER);

            documento.add(paragraph);
            documento.add(foto);
            documento.add(dadosMilitar);


            documento.close();


            return stream.toByteArray();

        } catch (Exception e) {
            return null;
        }
    }
}
