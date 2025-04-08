package com.juan.BestMeals.service;

import com.juan.BestMeals.dto.AvaliacaoDTO;
import com.juan.BestMeals.dto.CreateAvaliacaoDTO;
import com.juan.BestMeals.model.Avaliacao;
import com.juan.BestMeals.model.Prato;
import com.juan.BestMeals.repository.AvaliacaoRepository;
import com.juan.BestMeals.repository.PratoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // Indica que esta classe é um serviço da aplicação (camada de negócio)
public class AvaliacaoService {

    @Autowired // Injeta a instância do repositório de avaliações
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired // Injeta a instância do repositório de pratos
    private PratoRepository pratoRepository;

    /**
     * Cria uma nova avaliação para um prato específico.
     * @param dto DTO contendo os dados da avaliação a ser criada.
     * @return DTO da avaliação salva.
     */
    public AvaliacaoDTO criar(CreateAvaliacaoDTO dto) {
        // Busca o prato associado pela ID fornecida, ou lança exceção se não encontrado
        Prato prato = pratoRepository.findById(dto.getPratoId())
                .orElseThrow(() -> new EntityNotFoundException("Prato com ID " + dto.getPratoId() + " não encontrado"));

        // Cria nova instância de Avaliação e define seus campos
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setData(dto.getData());
        avaliacao.setNota(dto.getNota());
        avaliacao.setComentario(dto.getComentario());
        avaliacao.setPrato(prato); // Associa a avaliação ao prato

        // Salva no banco e retorna o DTO correspondente
        return toDTO(avaliacaoRepository.save(avaliacao));
    }

    /**
     * Lista todas as avaliações de um prato com base no ID do prato.
     * @param pratoId ID do prato a ser consultado.
     * @return Lista de DTOs das avaliações.
     */
    public List<AvaliacaoDTO> listarPorPrato(Long pratoId) {
        return avaliacaoRepository.findByPratoId(pratoId) // Busca todas as avaliações com base no ID do prato
                .stream()
                .map(this::toDTO) // Converte para DTO
                .collect(Collectors.toList());
    }

    /**
     * Converte uma entidade Avaliacao em AvaliacaoDTO.
     * @param avaliacao Entidade Avaliacao.
     * @return DTO equivalente.
     */
    private AvaliacaoDTO toDTO(Avaliacao avaliacao) {
        AvaliacaoDTO dto = new AvaliacaoDTO();
        dto.setId(avaliacao.getId());
        dto.setData(avaliacao.getData());
        dto.setNota(avaliacao.getNota());
        dto.setComentario(avaliacao.getComentario());
        dto.setPratoId(avaliacao.getPrato().getId()); // Adiciona ID do prato relacionado
        return dto;
    }
}
