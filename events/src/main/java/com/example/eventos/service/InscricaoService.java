package com.example.eventos.service;

import com.example.eventos.repository.*;
import com.example.eventos.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InscricaoService {
    private final InscricaoRepository inscricaoRepository;

    @Autowired
    public InscricaoService(InscricaoRepository inscricaoRepository) {
        this.inscricaoRepository = inscricaoRepository;
    }

    public List<Inscricao> getAllInscricoes() {
        return inscricaoRepository.findAll();
    }

    public Inscricao getInscricaoById(Long id) {
        return inscricaoRepository.findById(id).orElse(null);
    }

    public Inscricao createInscricao(Inscricao inscricao) {
        return inscricaoRepository.save(inscricao);
    }

    public Inscricao updateInscricao(Long id, Inscricao novaInscricao) {
        Inscricao inscricaoExistente = inscricaoRepository.findById(id).orElse(null);
        if (inscricaoExistente == null) {
            return null; // Lida com o caso de não encontrar a inscrição
        }
        // Atualize os campos relevantes da inscricaoExistente com os valores da novaInscricao
        inscricaoExistente.setEvento(novaInscricao.getEvento());
        inscricaoExistente.setEstudante(novaInscricao.getEstudante());
        return inscricaoRepository.save(inscricaoExistente);
    }

    public void deleteInscricao(Long id) {
        inscricaoRepository.deleteById(id);
    }
}
