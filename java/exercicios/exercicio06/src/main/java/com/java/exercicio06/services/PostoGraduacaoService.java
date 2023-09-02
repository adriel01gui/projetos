package com.java.exercicio06.services;

import com.java.exercicio06.dto.MilitarDTO;
import com.java.exercicio06.dto.PostoGraduacaoDTO;
import com.java.exercicio06.entities.Militar;
import com.java.exercicio06.entities.PostoGraduacao;
import com.java.exercicio06.repositories.PostoGraduacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PostoGraduacaoService {

    @Autowired
    private PostoGraduacaoRepository postoGraduacaoRepository;

    public List<PostoGraduacao> buscarPorCodigoMilitar(Integer codigoMilitar) {
        return postoGraduacaoRepository.buscarPorCodigoMililatar(codigoMilitar);
    }


    public List<MilitarDTO> listarDadosAgrupado() {
        //map <chave e Valor>
        //chave - pedido
        //valor - lista de itens pedido
        //groupby - agrupando com chave e valor
        Map<Militar, List<PostoGraduacao>> lista = postoGraduacaoRepository.
                findAll().
                stream().
                collect(Collectors.groupingBy(item -> item.getMilitar()));


        //Criando - inicializando um objeto do tipo Lista - pedidoDTOList
        List<MilitarDTO> pedidoDTOList = new ArrayList<>();


        //percorrendo a lista agrupada
        //a Declaracao do objeto Map.Entry<Pedido, List<ItensPedido>>
        //item da interacao - entry
        //lista.entrySet() - Lista

        for (Map.Entry<Militar, List<PostoGraduacao>> entry : lista.entrySet()) {

            MilitarDTO militarDTO = new MilitarDTO();
            //entry.getKey - chave
            militarDTO.setNome(entry.getKey().getNome());
            militarDTO.setDataNascimento(entry.getKey().getDataNascimento());
            Double total = 0.0;

            //adicionar o itens que forem passado entry.getValue - List<ItensPedido>
            List<PostoGraduacaoDTO> postoGraduacaoDTOS = new ArrayList<>();


            for (PostoGraduacao item : entry.getValue()) {

                MilitarDTO militarDTO1 = new MilitarDTO();
                militarDTO1.setNome(item.getMilitar().getNome());
                militarDTO1.setNomeGuerra(item.getMilitar().getNomeGuerra());
                militarDTO1.setDataNascimento(item.getMilitar().getDataNascimento());

                PostoGraduacaoDTO postoGraduacaoDTO1 = new PostoGraduacaoDTO();
                postoGraduacaoDTO1.setMilitar(militarDTO1);
                postoGraduacaoDTO1.setIdade(item.getIdade());


                postoGraduacaoDTOS.add(postoGraduacaoDTO1);
            }
            militarDTO.setItens(postoGraduacaoDTOS);

            pedidoDTOList.add(militarDTO);
        }
        return pedidoDTOList;
    }


}
