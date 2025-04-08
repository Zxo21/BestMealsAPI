package com.juan.BestMeals.repository;

import com.juan.BestMeals.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositório responsável por acessar os dados da entidade Avaliacao.
 * Estende JpaRepository, o que fornece métodos prontos para operações CRUD.
 */
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    /**
     * Busca todas as avaliações associadas a um prato específico.
     * Este método é interpretado automaticamente pelo Spring Data JPA
     * com base no nome do método e no nome do atributo da entidade Avaliacao.
     */
    List<Avaliacao> findByPratoId(Long pratoId);
}
