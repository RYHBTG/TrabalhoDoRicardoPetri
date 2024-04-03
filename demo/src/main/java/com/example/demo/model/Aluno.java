package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Aluno extends Pessoa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matricula;
    @NotNull
    @Column(nullable = false)
    private String turma;
    public Aluno() {
    }

    public Aluno(String nome, String cpf, String idade, Long matricula, String Turma) {
        super(nome, cpf, idade);
        this.matricula = matricula;
        this.turma = turma;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
}
