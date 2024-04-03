package com.example.demo.service;
import com.example.demo.model.Aluno;
import com.example.demo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService implements PessoaService<Aluno>{

    @Autowired
    AlunoRepository alunoRepository;

    @Override
    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno criar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno atualizar(Aluno aluno, Long matricula) {
        if(alunoRepository.existsById(matricula)) {
            aluno.setMatricula(matricula);
            return alunoRepository.save(aluno);
        } else {
            return null;
        }
    }

    @Override
    public boolean deletar(Long matricula) {
        if(alunoRepository.existsById(matricula)) {
            alunoRepository.deleteById(matricula);
            return true;
        } else {
            return false;
        }
    }

    public int qtdAlunos () {
        return alunoRepository.findAll().size();
    }

    public List<Aluno> listarPorTurma(String turma) {
        return alunoRepository.findByTurma(turma);
    }
}