package com.juan.BestMeals.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CreateAvaliacaoDTO {
    private LocalDate data;
    private String comentario;

    @NotNull
    private Long pratoId;

    @Min(0)
    @Max(5)
    private int nota;
    // Getters e Setters


    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getNota() {
        return nota;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setPratoId(Long pratoId) {
        this.pratoId = pratoId;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getPratoId() {
        return pratoId;
    }

}
