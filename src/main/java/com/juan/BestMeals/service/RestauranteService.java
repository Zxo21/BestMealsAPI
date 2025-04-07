package com.juan.BestMeals.service;

import com.juan.BestMeals.dto.CreateRestauranteDTO;
import com.juan.BestMeals.dto.DTOMapper;
import com.juan.BestMeals.dto.RestauranteDTO;
import com.juan.BestMeals.model.Restaurante;
import com.juan.BestMeals.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public List<RestauranteDTO> listarTodos() {
        return restauranteRepository.findAll().stream()
                .map(DTOMapper::toRestauranteDTO)
                .collect(Collectors.toList());
    }

    public RestauranteDTO buscarPorId(Long id) {
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));
        return DTOMapper.toRestauranteDTO(restaurante);
    }

    public RestauranteDTO criar(CreateRestauranteDTO dto) {
        Restaurante restaurante = DTOMapper.toRestauranteEntity(dto);
        restaurante = restauranteRepository.save(restaurante);
        return DTOMapper.toRestauranteDTO(restaurante);
    }

    public RestauranteDTO atualizar(Long id, CreateRestauranteDTO dto) {
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));

        restaurante.setNome(dto.getNome());
        restaurante.setEndereco(dto.getEndereco());
        restaurante.setTelefone(dto.getTelefone());

        return DTOMapper.toRestauranteDTO(restauranteRepository.save(restaurante));
    }

    public void deletar(Long id) {
        restauranteRepository.deleteById(id);
    }
}
