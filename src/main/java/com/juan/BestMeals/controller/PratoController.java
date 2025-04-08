package com.juan.BestMeals.controller;

import com.juan.BestMeals.dto.CreatePratoDTO;
import com.juan.BestMeals.dto.PratoDTO;
import com.juan.BestMeals.dto.UpdatePratoDTO;
import com.juan.BestMeals.service.PratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável por lidar com as requisições relacionadas aos pratos.
 * Define os endpoints para listar, buscar, criar, atualizar e deletar pratos.
 */
@RestController // Indica que esta classe é um controlador REST
@RequestMapping("/api/pratos") // Define a URL base para todos os métodos abaixo
public class PratoController {

    @Autowired // Injeta a dependência do serviço de pratos
    private PratoService pratoService;

    /**
     * Lista todos os pratos disponíveis.
     * Endpoint: GET /api/pratos
     */
    @GetMapping
    public List<PratoDTO> listar() {
        return pratoService.listarTodos();
    }

    /**
     * Busca um prato pelo ID.
     * Endpoint: GET /api/pratos/{id}
     */
    @GetMapping("/{id}")
    public PratoDTO buscar(@PathVariable Long id) {
        return pratoService.buscarPorId(id);
    }

    /**
     * Cria um novo prato.
     * Endpoint: POST /api/pratos
     * Corpo da requisição: JSON com nome, descrição, preço e restauranteId.
     */
    @PostMapping
    public PratoDTO criar(@RequestBody CreatePratoDTO dto) {
        return pratoService.criar(dto);
    }

    /**
     * Atualiza um prato existente.
     * Endpoint: PUT /api/pratos/{id}
     * Corpo da requisição: JSON com dados atualizados.
     * Retorna um ResponseEntity com o objeto atualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<PratoDTO> atualizar(@PathVariable Long id, @RequestBody UpdatePratoDTO dto) {
        return ResponseEntity.ok(pratoService.atualizar(id, dto));
    }

    /**
     * Deleta um prato pelo ID.
     * Endpoint: DELETE /api/pratos/{id}
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pratoService.deletar(id);
    }

}
