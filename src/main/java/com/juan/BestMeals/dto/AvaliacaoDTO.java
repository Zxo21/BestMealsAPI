package com.juan.BestMeals.dto;

import java.time.LocalDate;

/**
 * DTO que representa os dados de uma avaliação.
 * Usado geralmente em respostas (GET) para exibir informações de avaliações feitas por usuários.
 */
public class AvaliacaoDTO {

    private Long id;
    private LocalDate data;
    private int nota;
    private String comentario;
    private Long pratoId;

    // Getters e Setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }
    public void setNota(int nota) {
        this.nota = nota;
    }

    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Long getPratoId() {
        return pratoId;
    }
    public void setPratoId(Long pratoId) {
        this.pratoId = pratoId;
    }
}
