package com.juan.BestMeals.repository;

import com.juan.BestMeals.model.Prato;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repositório responsável pelas operações de acesso a dados da entidade Prato.
 * Estende JpaRepository para fornecer suporte completo a operações CRUD.
 */
public interface PratoRepository extends JpaRepository<Prato, Long> {
    // Neste momento, estamos utilizando apenas os métodos padrão do JpaRepository, como:
    // - findAll()
    // - findById(Long id)
    // - save(Prato entity)
    // - deleteById(Long id)
}
