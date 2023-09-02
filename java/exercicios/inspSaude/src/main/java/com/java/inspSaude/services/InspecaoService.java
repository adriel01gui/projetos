package com.java.inspSaude.services;

import com.java.inspSaude.dto.InspecaoDTO;
import com.java.inspSaude.dto.MilitarDTO;
import com.java.inspSaude.model.Inspecao;
import com.java.inspSaude.model.Militar;
import com.java.inspSaude.repositories.InspecaoRepository;
import com.java.inspSaude.repositories.MilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InspecaoService {

    @Autowired
    private InspecaoRepository inspecaoRepository;

    @Autowired
    private MilitarService militarService;

    @Autowired
    private MilitarRepository militarRepository;

    public void salvar(InspecaoDTO inspecaoDTO) throws Exception {

        Inspecao inspecao = new Inspecao();
        inspecao.setDataInspecao(inspecaoDTO.getDataInspecao());
        inspecao.setValidade(inspecaoDTO.getValidade());

        Inspecao inspecaoSalva = inspecaoRepository.save(inspecao);

        MilitarDTO militarDTO = null;
        if (inspecaoDTO.getMilitarDTO() != null) {
            militarDTO = militarService.buscarPorId(inspecaoDTO.getMilitarDTO().getId());
        } else {
            militarDTO = inspecaoDTO.getMilitarDTO();
        }
        militarService.salvar(militarDTO, inspecaoSalva);
    }
}