package com.juan.BestMeals.dto;

import java.math.BigDecimal;

/**
 * Classe DTO (Data Transfer Object) que representa os dados de um prato.
 * Usada para transferir dados entre camadas da aplicação, mantendo a separação
 * entre a entidade e a estrutura de dados utilizada nas comunicações.
 */
public class PratoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private RestauranteDTO restaurante;
    private Double mediaAvaliacao;

    // Getters e Setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

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

    public RestauranteDTO getRestaurante() {
        return restaurante;
    }
    public void setRestaurante(RestauranteDTO restaurante) {
        this.restaurante = restaurante;
    }

    public Double getMediaAvaliacao() {
        return mediaAvaliacao;
    }
    public void setMediaAvaliacao(Double mediaAvaliacao) {
        this.mediaAvaliacao = mediaAvaliacao;
    }

}
