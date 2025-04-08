package com.juan.BestMeals.controller;

import com.juan.BestMeals.dto.AvaliacaoDTO;
import com.juan.BestMeals.dto.CreateAvaliacaoDTO;
import com.juan.BestMeals.service.AvaliacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @PostMapping
    public AvaliacaoDTO criar(@RequestBody @Valid CreateAvaliacaoDTO dto) {
        return avaliacaoService.criar(dto);
    }

    @GetMapping("/prato/{pratoId}")
    public List<AvaliacaoDTO> listarPorPrato(@PathVariable Long pratoId) {
        return avaliacaoService.listarPorPrato(pratoId);
    }
}
