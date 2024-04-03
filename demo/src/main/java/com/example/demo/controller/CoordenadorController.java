package com.example.demo.controller;

import com.example.demo.model.Coordenador;
import com.example.demo.repository.CoordenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coordenador")
public class CoordenadorController {

    @Autowired
    CoordenadorRepository coordenadorRepository;

    @GetMapping
    public List<Coordenador> listarCoordenadores () {
        return coordenadorRepository.findAll();
    }

    @PostMapping
    public Coordenador criar (@RequestBody Coordenador coordenador) {
        return coordenadorRepository.save(coordenador);
    }


}
