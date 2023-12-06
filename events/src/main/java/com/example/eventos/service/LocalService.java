package com.example.eventos.service;

import com.example.eventos.repository.*;
import com.example.eventos.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocalService {
    private final LocalRepository localRepository;

    @Autowired
    public LocalService(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    public List<Local> getAllLocais() {
        return localRepository.findAll();
    }

    public Local getLocalById(Long id) {
        return localRepository.findById(id).orElse(null);
    }

    public Local createLocal(Local local) {
        return localRepository.save(local);
    }

    public Local updateLocal(Long id, Local novoLocal) {
        Local localExistente = localRepository.findById(id).orElse(null);
        if (localExistente == null) {
            return null; // Lida com o caso de não encontrar o local
        }
        // Atualize os campos relevantes do localExistente com os valores do novoLocal
        localExistente.setNome(novoLocal.getNome());
        localExistente.setEndereco(novoLocal.getEndereco());
        return localRepository.save(localExistente);
    }

    public void deleteLocal(Long id) {
        localRepository.deleteById(id);
    }
}

