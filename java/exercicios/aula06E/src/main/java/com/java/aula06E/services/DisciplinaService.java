package com.java.aula06E.services;

import com.java.aula06E.enums.DescricaoDisciplina;
import com.java.aula06E.models.Aluno;
import com.java.aula06E.models.Curso;
import com.java.aula06E.models.Disciplina;
import com.java.aula06E.repositories.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository repository;


    public Disciplina buscaPorId(Long id){
        return repository.findById(id).get();
    }

}