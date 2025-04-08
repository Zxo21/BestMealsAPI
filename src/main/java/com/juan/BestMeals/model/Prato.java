package com.juan.BestMeals.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Entidade que representa um Prato no sistema.
 */
@Entity
public class Prato {

    // Identificador único do prato, gerado automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private BigDecimal preco;

    // Relação muitos-para-um com Restaurante (vários pratos podem pertencer a um único restaurante)
    @ManyToOne
    @JoinColumn(name = "restaurante_id") // Define o nome da coluna que faz o join no banco de dados
    @JsonBackReference // Usado para evitar loop de serialização com JSON (em conjunto com @JsonManagedReference em Restaurante)
    private Restaurante restaurante;

    // Relação um-para-muitos com Avaliacao (um prato pode ter várias avaliações)
    @OneToMany(mappedBy = "prato", cascade = CascadeType.ALL)
    private List<Avaliacao> avaliacoes;

    // Getters e setters

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

    public Restaurante getRestaurante() {
        return restaurante;
    }
    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }
    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
