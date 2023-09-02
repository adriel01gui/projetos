package com.java.petshop.report;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.DocumentException;
import com.java.petshop.entities.dto.ItensVendaDTO;
import com.java.petshop.util.VendaTotalUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ItensVendaReport extends Report{

    private List<ItensVendaDTO> lista;


    public ItensVendaReport(List<ItensVendaDTO> lista){
        super();
        this.lista = lista;
    }


    public byte[] createPDF(){
        try {
            documento.open();

            addFoto("/static/imagens/petShop.png");
            addTitulo("Relatorio de vendas");

            PdfPTable table = new PdfPTable(7);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            PdfPCell headerCell = new PdfPCell(new Phrase("Dados da venda", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
            headerCell.setColspan(7); // Mescla todas as colunas do cabeçalho
            headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            headerCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(headerCell);

            table.addCell(" Cliente");
            table.addCell("Vendendor");
            table.addCell("Produto");
            table.addCell("Preço do produto");
            table.addCell("Quantidade");
            table.addCell("Data da venda");
            table.addCell("Valor da compra");

            Map<String, Double> totalPorCliente = new HashMap<>();

            for (ItensVendaDTO itensVendaDTO : lista) {
                String nomeCliente = itensVendaDTO.getCliente().getNome();
                double valorItem = itensVendaDTO.getProduto().getPreco() * itensVendaDTO.getQuantidade();

                totalPorCliente.merge(nomeCliente, valorItem, Double::sum);
            }

            for (ItensVendaDTO itensVendaDTO: lista){

                
                table.addCell(itensVendaDTO.getCliente().getNome());
                table.addCell(itensVendaDTO.getVenda().getQuemVendeu());
                table.addCell(itensVendaDTO.getProduto().getNome());
                table.addCell(itensVendaDTO.getProduto().getPreco().toString());
                table.addCell(itensVendaDTO.getQuantidade().toString());
                table.addCell(itensVendaDTO.getVenda().getDt_venda().toString());

                String nomeCliente = itensVendaDTO.getCliente().getNome();
                double totalCliente = totalPorCliente.getOrDefault(nomeCliente, 0.0);
                table.addCell(String.format("%.2f", totalCliente));
                documento.add(table);
            }


            documento.add(table);

            closeDocument();
            return stream.toByteArray();

        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }
}