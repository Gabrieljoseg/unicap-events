package com.example.events.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventoCategoriaService {
    private final EventoCategoriaRepository eventoCategoriaRepository;

    @Autowired
    public EventoCategoriaService(EventoCategoriaRepository eventoCategoriaRepository) {
        this.eventoCategoriaRepository = eventoCategoriaRepository;
    }

    public List<EventoCategoria> getAllEventoCategorias() {
        return eventoCategoriaRepository.findAll();
    }

    public EventoCategoria getEventoCategoriaById(Long id) {
        return eventoCategoriaRepository.findById(id).orElse(null);
    }

    public EventoCategoria createEventoCategoria(EventoCategoria eventoCategoria) {
        return eventoCategoriaRepository.save(eventoCategoria);
    }

    public EventoCategoria updateEventoCategoria(Long id, EventoCategoria novaEventoCategoria) {
        EventoCategoria eventoCategoriaExistente = eventoCategoriaRepository.findById(id).orElse(null);
        if (eventoCategoriaExistente == null) {
            return null; // Lida com o caso de não encontrar a associação de categoria
        }
        // Atualize os campos relevantes da eventoCategoriaExistente com os valores da novaEventoCategoria
        eventoCategoriaExistente.setEvento(novaEventoCategoria.getEvento());
        eventoCategoriaExistente.setCategoria(novaEventoCategoria.getCategoria());
        return eventoCategoriaRepository.save(eventoCategoriaExistente);
    }

    public void deleteEventoCategoria(Long id) {
        eventoCategoriaRepository.deleteById(id);
    }
}
