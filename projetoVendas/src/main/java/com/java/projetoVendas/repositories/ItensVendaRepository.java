package com.java.projetoVendas.repositories;

import com.java.projetoVendas.models.dto.ItensVendaDTO;
import com.java.projetoVendas.models.entities.ItensVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ItensVendaRepository extends JpaRepository<ItensVenda, Long> {

    @Query("select i from ItensVenda i where i.venda.id = :idVenda")
    List<ItensVenda> buscarPorIdVenda(@Param("idVenda") Integer idVenda);

}