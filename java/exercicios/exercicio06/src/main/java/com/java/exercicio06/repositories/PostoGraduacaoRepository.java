package com.java.exercicio06.repositories;

import com.java.exercicio06.entities.PostoGraduacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostoGraduacaoRepository extends JpaRepository<PostoGraduacao, Integer> {

    @Query("select p from PostoGraduacao p where p.militar.id = :idMilitar")
    List<PostoGraduacao> buscarPorCodigoMililatar(@Param("idMilitar") Integer idMilitar);
}
