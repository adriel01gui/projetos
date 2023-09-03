package com.java.backVendas.repositories;

import com.java.backVendas.models.ItensVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItensVendaRepository extends JpaRepository<ItensVenda,Long> {
}