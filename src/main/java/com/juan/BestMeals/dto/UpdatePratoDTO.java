package com.juan.BestMeals.dto;

import java.math.BigDecimal;

/**
 * DTO (Data Transfer Object) usado para atualizar as informações de um prato.
 * Ele carrega os dados necessários para a atualização, vindo geralmente do frontend.
 */
public class UpdatePratoDTO {

    private Long id;
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

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public BigDecimal getPreco() {
        return preco;
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getRestauranteId() {
        return restauranteId;
    }
    public void setRestauranteId(Long restauranteId) {
        this.restauranteId = restauranteId;
    }

}
