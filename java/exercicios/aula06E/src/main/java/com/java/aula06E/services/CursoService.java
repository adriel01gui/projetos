package com.java.aula06E.services;

import com.java.aula06E.models.Curso;
import com.java.aula06E.repositories.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    private CursosRepository repository;

    public Curso buscarPorId(Long id){
        return repository.findById(id).get();
    }
}