package com.juan.BestMeals.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String endereco;
    private String telefone;

    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Prato> pratos;

    public Long getId() {
        return this.id;
    }


    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public List<Prato> getPratos() { return pratos; }
    public void setPratos(List<Prato> pratos) { this.pratos = pratos; }
}
