package com.example.demo.controller;

import com.example.demo.model.Aluno;
import com.example.demo.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @GetMapping
    public List<Aluno> listarAlunos() {
        return alunoService.listar();
    }

    @PostMapping
    public Aluno criar(@Valid @RequestBody Aluno aluno) {
        return alunoService.criar(aluno); // Alteração feita aqui
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<?> atualizar(@PathVariable Long matricula, @RequestBody Aluno aluno) {

        if(alunoService.atualizar(aluno, matricula) == null) {

            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
        return ResponseEntity.ok(aluno);
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(alunoService.deletar(id)) {
            String mensagem = "A deleção do id: " + id + " foi realizada com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = "O id informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }

    @GetMapping("/qtd-alunos")
    public int qtdAlunos() {
        return alunoService.qtdAlunos();
    }

    @GetMapping("/listarturma/{turma}")
    public List<Aluno> listarPorTurma(@PathVariable String turma) {
        return alunoService.listarPorTurma(turma);
    }

}
