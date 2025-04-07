package com.juan.BestMeals.controller;

import com.juan.BestMeals.dto.CreatePratoDTO;
import com.juan.BestMeals.dto.PratoDTO;
import com.juan.BestMeals.dto.UpdatePratoDTO;
import com.juan.BestMeals.service.PratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pratos")
public class PratoController {

    @Autowired
    private PratoService pratoService;

    @GetMapping
    public List<PratoDTO> listar() {
        return pratoService.listarTodos();
    }

    @GetMapping("/{id}")
    public PratoDTO buscar(@PathVariable Long id) {
        return pratoService.buscarPorId(id);
    }

    @PostMapping
    public PratoDTO criar(@RequestBody CreatePratoDTO dto) {
        return pratoService.criar(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PratoDTO> atualizar(@PathVariable Long id, @RequestBody UpdatePratoDTO dto) {
        return ResponseEntity.ok(pratoService.atualizar(id, dto));
    }


    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pratoService.deletar(id);
    }

    @GetMapping("/top")
    public List<PratoDTO> listarTop10() {
        return pratoService.listarTopPratos();
    }
}
