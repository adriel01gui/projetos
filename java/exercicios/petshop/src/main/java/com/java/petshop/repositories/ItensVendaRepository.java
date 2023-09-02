package com.java.petshop.repositories;

import com.java.petshop.entities.ItensVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItensVendaRepository extends JpaRepository<ItensVenda,Long> {
}
