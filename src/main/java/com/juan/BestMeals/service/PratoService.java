package com.juan.BestMeals.service;

import com.juan.BestMeals.dto.CreatePratoDTO;
import com.juan.BestMeals.dto.PratoDTO;
import com.juan.BestMeals.dto.RestauranteDTO;
import com.juan.BestMeals.dto.UpdatePratoDTO;
import com.juan.BestMeals.model.Prato;
import com.juan.BestMeals.model.Restaurante;
import com.juan.BestMeals.repository.PratoRepository;
import com.juan.BestMeals.repository.RestauranteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // Indica que esta classe é um serviço gerenciado pelo Spring (camada de lógica de negócio)
public class PratoService {

    @Autowired // Injeta automaticamente a dependência do repositório de pratos
    private PratoRepository pratoRepository;

    @Autowired // Injeta automaticamente a dependência do repositório de restaurantes
    private RestauranteRepository restauranteRepository;

    // Retorna todos os pratos cadastrados convertidos em DTOs
    public List<PratoDTO> listarTodos() {
        return pratoRepository.findAll()
                .stream()
                .map(this::toDTO) // Converte entidade Prato em DTO
                .collect(Collectors.toList());
    }

    // Busca um prato pelo ID e retorna seu DTO
    public PratoDTO buscarPorId(Long id) {
        Prato prato = pratoRepository.findById(id).orElseThrow(); // Lança NoSuchElementException se não encontrar
        return toDTO(prato);
    }

    // Cria um novo prato associado a um restaurante existente
    public PratoDTO criar(CreatePratoDTO dto) {
        // Busca o restaurante pelo ID informado no DTO
        Restaurante restaurante = restauranteRepository.findById(dto.getRestauranteId())
                .orElseThrow(() -> new EntityNotFoundException("Restaurante com ID " + dto.getRestauranteId() + " não encontrado"));

        // Cria nova instância de prato e preenche os campos
        Prato prato = new Prato();
        prato.setNome(dto.getNome());
        prato.setDescricao(dto.getDescricao());
        prato.setPreco(dto.getPreco());
        prato.setRestaurante(restaurante); // Define o restaurante associado

        // Salva o prato e retorna o DTO correspondente
        return toDTO(pratoRepository.save(prato));
    }

    // Deleta um prato pelo ID
    public void deletar(Long id) {
        pratoRepository.deleteById(id);
    }

    // Atualiza os dados de um prato existente
    public PratoDTO atualizar(Long id, UpdatePratoDTO dto) {
        // Busca o prato no banco ou lança exceção se não encontrado
        Prato prato = pratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prato não encontrado"));

        // Atualiza os campos do prato
        prato.setNome(dto.getNome());
        prato.setDescricao(dto.getDescricao());
        prato.setPreco(dto.getPreco());

        // Salva as alterações e retorna o DTO
        return toDTO(pratoRepository.save(prato));
    }

    // Método auxiliar para converter entidade Prato em PratoDTO
    private PratoDTO toDTO(Prato prato) {
        PratoDTO dto = new PratoDTO();
        dto.setId(prato.getId());
        dto.setNome(prato.getNome());
        dto.setDescricao(prato.getDescricao());
        dto.setPreco(prato.getPreco());

        // Calcula a média das avaliações do prato, se existirem
        if (prato.getAvaliacoes() != null && !prato.getAvaliacoes().isEmpty()) {
            double media = prato.getAvaliacoes().stream()
                    .mapToInt(a -> a.getNota()) // Extrai as notas
                    .average() // Calcula a média
                    .orElse(0.0);
            dto.setMediaAvaliacao(media);
        } else {
            dto.setMediaAvaliacao(0.0); // Define média como 0 se não houver avaliações
        }

        // Converte os dados do restaurante associado ao prato para RestauranteDTO
        RestauranteDTO restauranteDTO = new RestauranteDTO();
        restauranteDTO.setId(prato.getRestaurante().getId());
        restauranteDTO.setNome(prato.getRestaurante().getNome());
        restauranteDTO.setEndereco(prato.getRestaurante().getEndereco());
        restauranteDTO.setTelefone(prato.getRestaurante().getTelefone());

        dto.setRestaurante(restauranteDTO); // Adiciona o restaurante ao DTO do prato
        return dto;
    }
}
