package com.juan.BestMeals.repository;

import com.juan.BestMeals.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório responsável por acessar os dados da entidade Restaurante.
 * Estende JpaRepository, fornecendo métodos prontos para operações CRUD.
 */
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
    // Nenhum método adicional é necessário neste momento,
    // pois JpaRepository já oferece métodos como:
    // - findAll()
    // - findById(Long id)
    // - save(Restaurante entity)
    // - deleteById(Long id)
}
