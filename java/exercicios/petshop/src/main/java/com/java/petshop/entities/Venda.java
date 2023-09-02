package com.java.petshop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String quemVendeu;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    private Date dt_venda;

}