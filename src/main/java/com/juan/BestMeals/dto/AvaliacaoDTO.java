package com.juan.BestMeals.dto;

import java.time.LocalDate;

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

    public LocalDate getData() {
        return data;
    }

    public Long getPratoId() {
        return pratoId;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setData(LocalDate data) {

    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setPratoId(Long pratoId) {
        this.pratoId = pratoId;
    }

}
