package com.java.inspSaude.repositories;

import com.java.inspSaude.model.Inspecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspecaoRepository extends JpaRepository<Inspecao, Long> {
}
