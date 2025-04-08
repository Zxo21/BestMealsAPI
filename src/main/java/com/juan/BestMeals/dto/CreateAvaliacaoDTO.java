package com.juan.BestMeals.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

/**
 * DTO utilizado para a criação de uma nova avaliação de prato.
 * Utilizado geralmente em requisições do tipo POST.
 */
public class CreateAvaliacaoDTO {

    private LocalDate data;
    private String comentario;

    // ID do prato que está sendo avaliado (obrigatório)
    @NotNull(message = "O ID do prato é obrigatório.")
    private Long pratoId;

    // Nota atribuída ao prato (de 0 a 5)
    @Min(value = 0, message = "A nota mínima é 0.")
    @Max(value = 5, message = "A nota máxima é 5.")
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
    public Long getPratoId() {
        return pratoId;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    public LocalDate getData() {
        return data;
    }
}
