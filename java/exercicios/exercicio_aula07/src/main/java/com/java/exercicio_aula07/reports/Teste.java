package com.java.exercicio_aula07.reports;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import com.java.exercicio_aula07.models.dto.ProdutoDTO;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class Teste {

    protected static Font FONT_TITULO = new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.BOLD);

    private List<ProdutoDTO> produtos;

    public Teste(ProdutoDTO produto) {
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
            Phrase titulo = new Phrase("Relatorio de Produtos", FONT_TITULO);
            paragraph.add(titulo);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            paragraph.setSpacingAfter(20);

            for (ProdutoDTO produtoDTO : produtos) {
                Paragraph dadosProduto = new Paragraph();
                dadosProduto.add("Codigo: " + produtoDTO.getId() + "\n");
                dadosProduto.add("Nome: " + produtoDTO.getNome() + "\n");
                dadosProduto.add("Preco: " + produtoDTO.getPreco() + "\n");
                dadosProduto.add("Situação: " + produtoDTO.getSituacao() + "\n");
                dadosProduto.setAlignment(Element.ALIGN_CENTER);
                paragraph.setAlignment(15);

                Image foto = Image.getInstance(IOUtils.toByteArray(getClass().getResourceAsStream("/static/tv.JPG")));
                foto.scaleAbsolute(80f, 80f);
                foto.setAlignment(Element.ALIGN_CENTER);

                documento.add(paragraph);
                documento.add(foto);
                documento.add(dadosProduto);

                // Adiciona um novo parágrafo para separar as informações de cada produto.
                Paragraph separador = new Paragraph();
                separador.setSpacingAfter(20);
                documento.add(separador);
            }

            documento.close();

            return stream.toByteArray();

        } catch (Exception e) {
            return null;
        }
    }
}
