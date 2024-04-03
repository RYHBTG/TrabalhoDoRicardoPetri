package com.example.demo.service;

import com.example.demo.model.Coordenador;
import com.example.demo.repository.CoordenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CoordenadorService implements PessoaService<Coordenador>{

    @Autowired
    CoordenadorRepository coordenadorRepository;

    @Override
    public List<Coordenador> listar() {
       return coordenadorRepository.findAll();
    }

    @Override
    public Coordenador criar(Coordenador coordenador) {
        return coordenadorRepository.save(coordenador);
    }

    @Override
    public Coordenador atualizar(Coordenador coordenador, Long id) {
        if(coordenadorRepository.existsById(id)) {
            coordenador.setId(id);
            return coordenadorRepository.save(coordenador);
        } else {
            return null;
        }
    }

    @Override
    public boolean deletar(Long id) {
        if(coordenadorRepository.existsById(id)) {
            coordenadorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}