package com.juan.BestMeals.repository;

import com.juan.BestMeals.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    List<Avaliacao> findByPratoId(Long pratoId);

}
