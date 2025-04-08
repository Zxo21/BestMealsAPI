package com.juan.BestMeals.model;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Entidade que representa uma Avaliação feita a um Prato.
 */
@Entity
public class Avaliacao {

    // Identificador único da avaliação, gerado automaticamente pelo banco
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Data da avaliação (usando o tipo LocalDate para representar a data)
    private LocalDate data;

    // Nota atribuída ao prato (ex: de 1 a 5)
    private int nota;

    // Comentário opcional da avaliação
    private String comentario;

    // Relação muitos-para-um com Prato (várias avaliações podem ser de um único prato)
    @ManyToOne
    @JoinColumn(name = "prato_id") // Define o nome da coluna de junção no banco
    private Prato prato;

    // Getters e Setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getNota() {
        return nota;
    }
    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Prato getPrato() {
        return prato;
    }
    public void setPrato(Prato prato) {
        this.prato = prato;
    }
}
