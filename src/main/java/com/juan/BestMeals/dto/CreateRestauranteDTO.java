package com.juan.BestMeals.dto;

/**
 * DTO utilizado para a criação de um novo restaurante.
 * Este objeto é comumente usado em requisições de criação (POST),
 * onde não é necessário informar o ID, pois ele será gerado automaticamente pelo sistema.
 */
public class CreateRestauranteDTO {
    private String nome;
    private String endereco;
    private String telefone;

    // Getters e Setters

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getTelefone() {
        return telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getEndereco() {
        return endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
}
