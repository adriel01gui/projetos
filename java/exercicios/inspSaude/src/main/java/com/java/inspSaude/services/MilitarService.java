package com.java.inspSaude.services;

import com.java.inspSaude.client.MilitarClient;
import com.java.inspSaude.dto.MilitarDTO;
import com.java.inspSaude.model.Inspecao;
import com.java.inspSaude.model.Militar;
import com.java.inspSaude.repositories.MilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MilitarService {

    @Autowired
    private MilitarRepository militarRepository;


    @Autowired
    private MilitarClient militarClient;

    public MilitarDTO buscarPorId(Long id) throws Exception {
        return militarClient.buscarporId(id);
    }
    public Militar salvar(MilitarDTO militarDTO, Inspecao inspecao) {
        Militar militar = new Militar();
        militar.setId(militarDTO.getId());
        militar.setName(militarDTO.getName());
        militar.setHeight(militarDTO.getHeight());
        militar.setMass(militarDTO.getMass());
        militar.setInspecao(inspecao);
        return militarRepository.save(militar);
    }

}