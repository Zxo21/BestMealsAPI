package com.juan.BestMeals.controller;

import com.juan.BestMeals.dto.CreateRestauranteDTO;
import com.juan.BestMeals.dto.RestauranteDTO;
import com.juan.BestMeals.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável por lidar com requisições relacionadas a restaurantes.
 * Expõe endpoints para listar, buscar, criar, atualizar e deletar restaurantes.
 */
@RestController // Indica que esta classe é um controlador REST
@RequestMapping("/api/restaurantes") // Define o endpoint base para os métodos abaixo
public class RestauranteController {

    @Autowired // Injeta a dependência do RestauranteService
    private RestauranteService restauranteService;

    /**
     * Lista todos os restaurantes.
     * Exemplo: GET /api/restaurantes
     */
    @GetMapping
    public List<RestauranteDTO> listar() {
        return restauranteService.listarTodos();
    }

    /**
     * Busca um restaurante pelo ID.
     * Exemplo: GET /api/restaurantes/1
     */
    @GetMapping("/{id}")
    public RestauranteDTO buscar(@PathVariable Long id) {
        return restauranteService.buscarPorId(id);
    }

    /**
     * Cria um novo restaurante.
     * Exemplo: POST /api/restaurantes
     * Corpo da requisição: JSON com nome, endereço e telefone.
     */
    @PostMapping
    public RestauranteDTO criar(@RequestBody CreateRestauranteDTO dto) {
        return restauranteService.criar(dto);
    }

    /**
     * Atualiza um restaurante existente.
     * Exemplo: PUT /api/restaurantes/1
     * Corpo da requisição: JSON com novos dados.
     */
    @PutMapping("/{id}")
    public RestauranteDTO atualizar(@PathVariable Long id, @RequestBody CreateRestauranteDTO dto) {
        return restauranteService.atualizar(id, dto);
    }

    /**
     * Deleta um restaurante pelo ID.
     * Exemplo: DELETE /api/restaurantes/1
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        restauranteService.deletar(id);
    }
}
