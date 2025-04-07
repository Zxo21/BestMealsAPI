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

@Service
public class PratoService {

    @Autowired
    private PratoRepository pratoRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    public List<PratoDTO> listarTodos() {
        return pratoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public PratoDTO buscarPorId(Long id) {
        Prato prato = pratoRepository.findById(id).orElseThrow();
        return toDTO(prato);
    }

    public PratoDTO criar(CreatePratoDTO dto) {
        Restaurante restaurante = restauranteRepository.findById(dto.getRestauranteId())
                .orElseThrow(() -> new EntityNotFoundException("Restaurante com ID " + dto.getRestauranteId() + " não encontrado"));;

        Prato prato = new Prato();
        prato.setNome(dto.getNome());
        prato.setDescricao(dto.getDescricao());
        prato.setPreco(dto.getPreco());
        prato.setRestaurante(restaurante);

        return toDTO(pratoRepository.save(prato));
    }

    public void deletar(Long id) {
        pratoRepository.deleteById(id);
    }

    public PratoDTO atualizar(Long id, UpdatePratoDTO dto) {
        Prato prato = pratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prato não encontrado"));

        prato.setNome(dto.getNome());
        prato.setDescricao(dto.getDescricao());
        prato.setPreco(dto.getPreco());

        return toDTO(pratoRepository.save(prato));
    }

    private PratoDTO toDTO(Prato prato) {
        PratoDTO dto = new PratoDTO();
        dto.setId(prato.getId());
        dto.setNome(prato.getNome());
        dto.setDescricao(prato.getDescricao());
        dto.setPreco(prato.getPreco());

        RestauranteDTO restauranteDTO = new RestauranteDTO();
        restauranteDTO.setId(prato.getRestaurante().getId());
        restauranteDTO.setNome(prato.getRestaurante().getNome());
        restauranteDTO.setEndereco(prato.getRestaurante().getEndereco());
        restauranteDTO.setTelefone(prato.getRestaurante().getTelefone());

        dto.setRestaurante(restauranteDTO);
        return dto;
    }
}
