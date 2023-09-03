package com.java.backVendas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quemVendeu", length = 50, nullable = false)
    private String quemVendeu;

    @Column(name = "nomeCliente", length = 50, nullable = false)
    private String nomeCliente;
}