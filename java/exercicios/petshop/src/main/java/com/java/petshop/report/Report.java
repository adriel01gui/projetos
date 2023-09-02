package com.java.petshop.report;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;

public class Report {

    protected static Font FONT_TITULO = new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.BOLD);

    protected Document documento;
    protected ByteArrayOutputStream stream;

    public Report() {
        documento = new Document(PageSize.A4);
        documento.setMargins(20, 20, 20, 20);

        stream = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(documento, stream);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    protected void addTitulo(String titulo) throws DocumentException {
        Paragraph paragraph = new Paragraph();
        Phrase phrase = new Phrase(titulo, FONT_TITULO);
        paragraph.add(phrase);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        paragraph.setSpacingAfter(20);
        documento.add(paragraph);
    }

    protected void addFoto(String imagePath) throws DocumentException {
        try {
            Image foto = Image.getInstance(IOUtils.toByteArray(getClass().getResourceAsStream(imagePath)));
            foto.scaleAbsolute(100f, 100f);
            foto.setAlignment(Element.ALIGN_CENTER);
            documento.add(foto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void closeDocument() {
        if (documento.isOpen()) {
            documento.close();
        }
    }
}
