package com.juan.BestMeals.dto;

/**
 * Classe DTO (Data Transfer Object) que representa os dados de um restaurante.
 * Utilizada para transportar informações entre diferentes camadas da aplicação,
 * como entre o backend e o frontend, ou entre a camada de serviço e o controlador.
 */
public class RestauranteDTO {
        private Long id;
        private String nome;
        private String endereco;
        private String telefone;

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

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
