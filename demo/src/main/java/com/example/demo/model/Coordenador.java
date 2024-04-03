package com.example.demo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Entity
public class Coordenador extends Professor {
    @NotNull
    @Size(min = 5, max = 20)
    @Column(nullable = false)
    private String senha;
    public Coordenador() {
    }

    public Coordenador(String nome, String cpf, String idade, double salario, String senha, String materia) {
        super(nome, cpf, idade, salario, materia);
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}