package com.example.events.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/eventolocais")
public class EventoLocalController {
    private final EventoLocalService eventoLocalService;

    @Autowired
    public EventoLocalController(EventoLocalService eventoLocalService) {
        this.eventoLocalService = eventoLocalService;
    }

    @GetMapping("/")
    public ResponseEntity<List<EventoLocal>> getAllEventoLocais() {
        List<EventoLocal> eventoLocais = eventoLocalService.getAllEventoLocais();
        return new ResponseEntity<>(eventoLocais, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoLocal> getEventoLocalById(@PathVariable Long id) {
        EventoLocal eventoLocal = eventoLocalService.getEventoLocalById(id);
        if (eventoLocal == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(eventoLocal, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<EventoLocal> createEventoLocal(@RequestBody EventoLocal eventoLocal) {
        EventoLocal novoEventoLocal = eventoLocalService.createEventoLocal(eventoLocal);
        return new ResponseEntity<>(novoEventoLocal, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoLocal> updateEventoLocal(@PathVariable Long id, @RequestBody EventoLocal novoEventoLocal) {
        EventoLocal eventoLocalAtualizado = eventoLocalService.updateEventoLocal(id, novoEventoLocal);
        if (eventoLocalAtualizado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(eventoLocalAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEventoLocal(@PathVariable Long id) {
        eventoLocalService.deleteEventoLocal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
