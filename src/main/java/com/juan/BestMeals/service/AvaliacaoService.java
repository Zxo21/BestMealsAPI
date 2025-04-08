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

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private PratoRepository pratoRepository;

    public AvaliacaoDTO criar(CreateAvaliacaoDTO dto) {
        Prato prato = pratoRepository.findById(dto.getPratoId())
                .orElseThrow(() -> new EntityNotFoundException("Prato com ID " + dto.getPratoId() + " não encontrado"));

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setData(dto.getData());
        avaliacao.setNota(dto.getNota());
        avaliacao.setComentario(dto.getComentario());
        avaliacao.setPrato(prato);

        return toDTO(avaliacaoRepository.save(avaliacao));
    }

    public List<AvaliacaoDTO> listarPorPrato(Long pratoId) {
        return avaliacaoRepository.findByPratoId(pratoId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private AvaliacaoDTO toDTO(Avaliacao avaliacao) {
        AvaliacaoDTO dto = new AvaliacaoDTO();
        dto.setId(avaliacao.getId());
        dto.setData(avaliacao.getData());
        dto.setNota(avaliacao.getNota());
        dto.setComentario(avaliacao.getComentario());
        dto.setPratoId(avaliacao.getPrato().getId());
        return dto;
    }
}
