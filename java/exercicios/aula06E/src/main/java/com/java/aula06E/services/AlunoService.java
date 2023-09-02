package com.java.aula06E.services;

import com.java.aula06E.models.Aluno;
import com.java.aula06E.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public Aluno buscaPorId(Long id){
        return repository.findById(id).get();
    }

    public Aluno buscaPorNome(String nome){
        return repository.findByNome(nome);
    }
}
