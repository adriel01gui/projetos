package com.java.aula06E.repositories;

import com.java.aula06E.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursosRepository extends JpaRepository<Curso,Long> {
}
