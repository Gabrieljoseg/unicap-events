package com.example.eventos.service;

import com.example.eventos.repository.*;
import com.example.eventos.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstudanteService {
    private final EstudanteRepository estudanteRepository;

    @Autowired
    public EstudanteService(EstudanteRepository estudanteRepository) {
        this.estudanteRepository = estudanteRepository;
    }

    public List<Estudante> getAllEstudantes() {
        return estudanteRepository.findAll();
    }

    public Estudante getEstudanteById(Long id) {
        return estudanteRepository.findById(id).orElse(null);
    }

    public Estudante createEstudante(Estudante estudante) {
        return estudanteRepository.save(estudante);
    }

    public Estudante updateEstudante(Long id, Estudante novoEstudante) {
        Estudante estudanteExistente = estudanteRepository.findById(id).orElse(null);
        if (estudanteExistente == null) {
            return null; // Lida com o caso de não encontrar o estudante
        }
        // Atualize os campos relevantes do estudanteExistente com os valores de novoEstudante
        estudanteExistente.setNome(novoEstudante.getNome());
        estudanteExistente.setEmail(novoEstudante.getEmail());
        return estudanteRepository.save(estudanteExistente);
    }

    public void deleteEstudante(Long id) {
        estudanteRepository.deleteById(id);
    }
}
