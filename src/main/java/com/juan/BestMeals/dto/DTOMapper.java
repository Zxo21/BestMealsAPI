package com.juan.BestMeals.dto;

import com.juan.BestMeals.model.Prato;
import com.juan.BestMeals.model.Restaurante;

public class DTOMapper {

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
