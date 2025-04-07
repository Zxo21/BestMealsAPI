package com.juan.BestMeals.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int nota;
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "prato_id")
    private Prato prato;

    private LocalDateTime data = LocalDateTime.now();

    public Prato getPrato() {
        return prato;
    }

    public void setPrato(Prato prato) {
        this.prato = prato;
    }

    public void setData(LocalDateTime data){
        this.data = data;
    }
}

