package com.juan.BestMeals.dto;

import com.juan.BestMeals.model.Prato;
import com.juan.BestMeals.model.Restaurante;

public class DTOMapper {

    public static PratoDTO toPratoDTO(Prato prato) {
        PratoDTO dto = new PratoDTO();
        dto.setId(prato.getId());
        dto.setNome(prato.getNome());
        dto.setDescricao(prato.getDescricao());
        dto.setPreco(prato.getPreco());

        Restaurante restaurante = prato.getRestaurante();
        RestauranteDTO restauranteDTO = new RestauranteDTO();
        restauranteDTO.setId(restaurante.getId());
        restauranteDTO.setNome(restaurante.getNome());
        restauranteDTO.setEndereco(restaurante.getEndereco());
        restauranteDTO.setTelefone(restaurante.getTelefone());

        dto.setRestaurante(restauranteDTO);
        return dto;
    }

    public static RestauranteDTO toRestauranteDTO(Restaurante restaurante) {
        RestauranteDTO dto = new RestauranteDTO();
        dto.setId(restaurante.getId());
        dto.setNome(restaurante.getNome());
        dto.setEndereco(restaurante.getEndereco());
        dto.setTelefone(restaurante.getTelefone());
        return dto;
    }

    public static Restaurante toRestauranteEntity(CreateRestauranteDTO dto) {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome(dto.getNome());
        restaurante.setEndereco(dto.getEndereco());
        restaurante.setTelefone(dto.getTelefone());
        return restaurante;
    }
}
