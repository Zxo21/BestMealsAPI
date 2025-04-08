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

@Service // Indica que essa classe é um serviço do Spring (componente de lógica de negócio)
public class RestauranteService {

    @Autowired // Injeta automaticamente uma instância do RestauranteRepository
    private RestauranteRepository restauranteRepository;

    // Retorna uma lista de todos os restaurantes cadastrados no sistema
    public List<RestauranteDTO> listarTodos() {
        return restauranteRepository.findAll().stream()
                .map(DTOMapper::toRestauranteDTO) // Converte cada entidade Restaurante para RestauranteDTO
                .collect(Collectors.toList());
    }

    // Busca um restaurante pelo ID e retorna seu DTO correspondente
    public RestauranteDTO buscarPorId(Long id) {
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurante não encontrado")); // Lança exceção se não encontrar
        return DTOMapper.toRestauranteDTO(restaurante);
    }

    // Cria um novo restaurante com os dados fornecidos em CreateRestauranteDTO
    public RestauranteDTO criar(CreateRestauranteDTO dto) {
        Restaurante restaurante = DTOMapper.toRestauranteEntity(dto); // Converte DTO para entidade
        restaurante = restauranteRepository.save(restaurante); // Salva no banco de dados
        return DTOMapper.toRestauranteDTO(restaurante); // Retorna DTO do restaurante salvo
    }

    // Atualiza os dados de um restaurante existente com base no ID e no DTO recebido
    public RestauranteDTO atualizar(Long id, CreateRestauranteDTO dto) {
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurante não encontrado")); // Lança exceção se não encontrar

        // Atualiza os campos do restaurante com os novos dados
        restaurante.setNome(dto.getNome());
        restaurante.setEndereco(dto.getEndereco());
        restaurante.setTelefone(dto.getTelefone());

        // Salva as alterações e retorna o DTO atualizado
        return DTOMapper.toRestauranteDTO(restauranteRepository.save(restaurante));
    }

    // Deleta um restaurante com base no ID
    public void deletar(Long id) {
        restauranteRepository.deleteById(id); // Remove o registro do banco de dados
    }
}
