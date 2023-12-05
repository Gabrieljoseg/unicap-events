package com.example.events.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria getCategoriaById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria updateCategoria(Long id, Categoria novaCategoria) {
        Categoria categoriaExistente = categoriaRepository.findById(id).orElse(null);
        if (categoriaExistente == null) {
            return null; // Lida com o caso de não encontrar a categoria
        }
        // Atualize os campos relevantes da categoriaExistente com os valores da novaCategoria
        categoriaExistente.setNome(novaCategoria.getNome());
        return categoriaRepository.save(categoriaExistente);
    }

    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}

