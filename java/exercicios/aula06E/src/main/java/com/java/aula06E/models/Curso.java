package com.java.aula06E.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    @OneToMany()
    @JoinColumn(name = "id_disciplina")
    private Set<Disciplina> disciplinas;
}