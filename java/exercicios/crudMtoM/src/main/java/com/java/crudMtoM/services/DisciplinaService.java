package com.java.crudMtoM.services;

import com.java.crudMtoM.model.Disciplina;
import com.java.crudMtoM.model.dto.DisciplinaDTO;
import com.java.crudMtoM.repositories.DisciplinaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    ModelMapper modelMapper = new ModelMapper();

    public void salvar(DisciplinaDTO disciplinaDTO) throws Exception {
        Disciplina disciplina = modelMapper.map(disciplinaDTO, Disciplina.class);
        disciplinaRepository.save(disciplina);
    }
}
