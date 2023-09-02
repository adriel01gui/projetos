package com.java.inspSaude.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inspecao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataInspecao;
    private LocalDate Validade;

    @ManyToOne
    @JoinColumn(name = "militar_id") // Certifique-se de usar o nome da coluna correto
    private Militar militar;
}