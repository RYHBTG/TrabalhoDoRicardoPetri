// Professor.java
package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Professor extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    @Min(value = 1)
    private double salario;
    @NotNull
    @Column(nullable = false)
    @Size(min = 1, max = 55)
    private String materia;

    public Professor() {
    }

    public Professor(String nome, String cpf, String idade, double salario, String materia) {
        super(nome, cpf, idade);
        this.salario = salario;
        this.materia = materia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
