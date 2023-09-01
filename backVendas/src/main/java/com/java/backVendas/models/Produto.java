package com.java.backVendas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomeProduto",length = 20, nullable = false)
    private String nome;

    @Column(name = "precoCompra", length = 10, nullable = false)
    private Double precoCompra;

    @Column(name = "precoVenda", length = 10, nullable = false)
    private Double precoVenda;
}
