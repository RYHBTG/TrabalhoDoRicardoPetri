package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



@MappedSuperclass
public abstract class Pessoa {
    @NotNull
    @Column(nullable = false)
    private String nome;
    @NotNull
    @Column(nullable = false)
    @Size(min = 11, max = 11)
    private String cpf;
    @NotNull
    @Column(nullable = false)
    @Size(min = 1, max = 3)
    private String idade;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
}
