package com.example.eventos.service;

import com.example.eventos.repository.*;
import com.example.eventos.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventoLocalService {
    private final EventoLocalRepository eventoLocalRepository;

    @Autowired
    public EventoLocalService(EventoLocalRepository eventoLocalRepository) {
        this.eventoLocalRepository = eventoLocalRepository;
    }

    public List<EventoLocal> getAllEventoLocais() {
        return eventoLocalRepository.findAll();
    }

    public EventoLocal getEventoLocalById(Long id) {
        return eventoLocalRepository.findById(id).orElse(null);
    }

    public EventoLocal createEventoLocal(EventoLocal eventoLocal) {
        return eventoLocalRepository.save(eventoLocal);
    }

    public EventoLocal updateEventoLocal(Long id, EventoLocal novoEventoLocal) {
        EventoLocal eventoLocalExistente = eventoLocalRepository.findById(id).orElse(null);
        if (eventoLocalExistente == null) {
            return null; // Lida com o caso de não encontrar a associação de evento e local
        }
        // Atualize os campos relevantes do eventoLocalExistente com os valores do novoEventoLocal
        eventoLocalExistente.setEvento(novoEventoLocal.getEvento());
        eventoLocalExistente.setLocal(novoEventoLocal.getLocal());
        return eventoLocalRepository.save(eventoLocalExistente);
    }

    public void deleteEventoLocal(Long id) {
        eventoLocalRepository.deleteById(id);
    }
}
