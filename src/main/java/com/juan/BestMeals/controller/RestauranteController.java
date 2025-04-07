package com.juan.BestMeals.controller;

import com.juan.BestMeals.dto.CreateRestauranteDTO;
import com.juan.BestMeals.dto.RestauranteDTO;
import com.juan.BestMeals.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping
    public List<RestauranteDTO> listar() {
        return restauranteService.listarTodos();
    }

    @GetMapping("/{id}")
    public RestauranteDTO buscar(@PathVariable Long id) {
        return restauranteService.buscarPorId(id);
    }

    @PostMapping
    public RestauranteDTO criar(@RequestBody CreateRestauranteDTO dto) {
        return restauranteService.criar(dto);
    }

    @PutMapping("/{id}")
    public RestauranteDTO atualizar(@PathVariable Long id, @RequestBody CreateRestauranteDTO dto) {
        return restauranteService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        restauranteService.deletar(id);
    }
}
