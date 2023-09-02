package com.java.crudMtoM.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToMany(mappedBy = "disciplinas")
    private List<Aluno> alunos;

    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
        aluno.getDisciplinas().add(this);
    }
}