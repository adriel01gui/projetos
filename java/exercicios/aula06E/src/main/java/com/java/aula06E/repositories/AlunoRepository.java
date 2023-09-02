package com.java.aula06E.repositories;

import com.java.aula06E.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Long> {

    Aluno findByNome(@Param("nome")String nome);
}
