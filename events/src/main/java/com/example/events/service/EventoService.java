package com.example.events.service; 

import com.example.events.repository.EventoRepository;
import com.example.events.model.Evento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventoService {
    private final EventoRepository eventoRepository;

    @Autowired
    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public List<Evento> getAllEventos() {
        return eventoRepository.findAll();
    }

    public Evento getEventoById(Long id) {
        return eventoRepository.findById(id).orElse(null);
    }

    public Evento createEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Evento updateEvento(Long id, Evento novoEvento) {
        Evento eventoExistente = eventoRepository.findById(id).orElse(null);
        if (eventoExistente == null) {
            return null; // Lida com o caso de não encontrar o evento
        }
        // Atualize os campos relevantes do eventoExistente com os valores de novoEvento
        eventoExistente.setNome(novoEvento.getNome());
        eventoExistente.setDescricao(novoEvento.getDescricao());
        return eventoRepository.save(eventoExistente);
    }

    public void deleteEvento(Long id) {
        eventoRepository.deleteById(id);
    }
}

