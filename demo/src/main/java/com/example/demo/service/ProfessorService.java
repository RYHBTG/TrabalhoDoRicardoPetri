package com.example.demo.service;

import com.example.demo.model.Professor;
import com.example.demo.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    public List<Professor> listarProfessores() {
        return professorRepository.findAll();
    }

    public Professor criar(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor atualizar(Long id, Professor professor) {
        Optional<Professor> professorOptional = professorRepository.findById(id);
        if (professorOptional.isPresent()) {
            Professor existingProfessor = professorOptional.get();
            existingProfessor.setNome(professor.getNome());
            existingProfessor.setCpf(professor.getCpf());
            existingProfessor.setIdade(professor.getIdade());
            existingProfessor.setSalario(professor.getSalario());
            existingProfessor.setMateria(professor.getMateria());
            return professorRepository.save(existingProfessor);
        }
        return null;
    }

    public boolean deletar(Long id) {
        if (professorRepository.existsById(id)) {
            professorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public int qtdProfessores() {
        return (int) professorRepository.count();
    }
}
