package com.juan.BestMeals.dto;

import com.juan.BestMeals.model.Prato;
import com.juan.BestMeals.model.Restaurante;

/**
 * Classe utilitária responsável por converter entidades do modelo para DTOs (e vice-versa).
 * Essa abordagem ajuda a separar a lógica de negócio da estrutura de transporte de dados.
 */
public class DTOMapper {

    /**
     * Converte um objeto da entidade Prato para um objeto PratoDTO.
     *
     * @param prato objeto da entidade Prato a ser convertido
     * @return objeto PratoDTO correspondente
     */
    public static PratoDTO toPratoDTO(Prato prato) {
        PratoDTO dto = new PratoDTO();
        dto.setId(prato.getId());
        dto.setNome(prato.getNome());
        dto.setDescricao(prato.getDescricao());
        dto.setPreco(prato.getPreco());

        // Converte o restaurante associado ao prato
        Restaurante restaurante = prato.getRestaurante();
        RestauranteDTO restauranteDTO = new RestauranteDTO();
        restauranteDTO.setId(restaurante.getId());
        restauranteDTO.setNome(restaurante.getNome());
        restauranteDTO.setEndereco(restaurante.getEndereco());
        restauranteDTO.setTelefone(restaurante.getTelefone());

        dto.setRestaurante(restauranteDTO);

        return dto;
    }

    /**
     * Converte um objeto da entidade Restaurante para um objeto RestauranteDTO.
     *
     * @param restaurante objeto da entidade Restaurante a ser convertido
     * @return objeto RestauranteDTO correspondente
     */
    public static RestauranteDTO toRestauranteDTO(Restaurante restaurante) {
        RestauranteDTO dto = new RestauranteDTO();
        dto.setId(restaurante.getId());
        dto.setNome(restaurante.getNome());
        dto.setEndereco(restaurante.getEndereco());
        dto.setTelefone(restaurante.getTelefone());
        return dto;
    }

    /**
     * Converte um objeto CreateRestauranteDTO (normalmente vindo do frontend) para a entidade Restaurante.
     * Ideal para criação de novos restaurantes.
     *
     * @param dto DTO com dados para criação de um restaurante
     * @return objeto Restaurante correspondente
     */
    public static Restaurante toRestauranteEntity(CreateRestauranteDTO dto) {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome(dto.getNome());
        restaurante.setEndereco(dto.getEndereco());
        restaurante.setTelefone(dto.getTelefone());
        return restaurante;
    }
}
