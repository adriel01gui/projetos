package com.java.projetoVendas.report;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.java.projetoVendas.models.dto.ItensVendaDTO;
import com.java.projetoVendas.models.dto.ProdutoDTO;

import java.io.ByteArrayOutputStream;

public class VendaReport {

    protected static Font FONT_TITULO = new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.BOLD);

    private ProdutoDTO produtoDTO;

    public VendaReport(ProdutoDTO produtoDTO) {
        this.produtoDTO = produtoDTO;
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
            Phrase titulo = new Phrase("Relatorio de Vendas", FONT_TITULO);
            paragraph.add(titulo);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            paragraph.setSpacingAfter(20);
            paragraph.add("\n");

            Paragraph dadosVenda = new Paragraph();
            dadosVenda.add("Nome: " + produtoDTO.getNome() + "\n");
            dadosVenda.add("Categoria: " + produtoDTO.getCategoria() + "\n");
            dadosVenda.add("Preço compra: " + produtoDTO.getPrecoCompra() + "\n");
            dadosVenda.add("Preço venda: " + produtoDTO.getPrecoVenda() + "\n");
            dadosVenda.setAlignment(Element.ALIGN_CENTER);
            paragraph.setAlignment(15);

            documento.add(paragraph);
            documento.add(dadosVenda);

            documento.close();

            return stream.toByteArray();

        } catch (Exception e) {
            return null;
        }
    }
}