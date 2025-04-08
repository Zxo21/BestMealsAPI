package com.juan.BestMeals.dto;

import java.math.BigDecimal;

/**
 * DTO utilizado para a criação de um novo prato.
 * Este objeto é normalmente utilizado em requisições do tipo POST,
 * onde é enviado os dados necessários para cadastrar um prato no sistema.
 */
public class CreatePratoDTO {
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Long restauranteId;

    // Getters e Setters

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Long getRestauranteId() {
        return restauranteId;
    }
    public void setRestauranteId(Long restauranteId) {
        this.restauranteId = restauranteId;
    }
}
