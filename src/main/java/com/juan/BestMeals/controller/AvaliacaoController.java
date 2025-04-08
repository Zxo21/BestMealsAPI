package com.juan.BestMeals.controller;

import com.juan.BestMeals.dto.AvaliacaoDTO;
import com.juan.BestMeals.dto.CreateAvaliacaoDTO;
import com.juan.BestMeals.service.AvaliacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável por gerenciar as avaliações dos pratos.
 * Expõe endpoints REST para criar avaliações e listar avaliações por prato.
 */
@RestController // Define que esta classe é um controlador REST
@RequestMapping("/api/avaliacoes") // Define a URL base dos endpoints
public class AvaliacaoController {

    @Autowired // Injeta automaticamente o serviço de avaliação
    private AvaliacaoService avaliacaoService;

    /**
     * Endpoint para criar uma nova avaliação.
     * POST /api/avaliacoes
     * Corpo da requisição: CreateAvaliacaoDTO (validação aplicada com @Valid)
     * Retorna: AvaliacaoDTO com os dados da avaliação criada
     */
    @PostMapping
    public AvaliacaoDTO criar(@RequestBody @Valid CreateAvaliacaoDTO dto) {
        return avaliacaoService.criar(dto);
    }

    /**
     * Endpoint para listar avaliações de um prato específico.
     * GET /api/avaliacoes/prato/{pratoId}
     * Parâmetro: ID do prato
     * Retorna: Lista de AvaliacaoDTO
     */
    @GetMapping("/prato/{pratoId}")
    public List<AvaliacaoDTO> listarPorPrato(@PathVariable Long pratoId) {
        return avaliacaoService.listarPorPrato(pratoId);
    }
}
