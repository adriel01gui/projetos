package com.java.inspSaude.repositories;

import com.java.inspSaude.model.Militar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MilitarRepository extends JpaRepository<Militar, Long> {
}
