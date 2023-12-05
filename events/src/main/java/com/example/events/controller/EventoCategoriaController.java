package com.example.events.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/eventocategorias")
public class EventoCategoriaController {
    private final EventoCategoriaService eventoCategoriaService;

    @Autowired
    public EventoCategoriaController(EventoCategoriaService eventoCategoriaService) {
        this.eventoCategoriaService = eventoCategoriaService;
    }

    @GetMapping("/")
    public ResponseEntity<List<EventoCategoria>> getAllEventoCategorias() {
        List<EventoCategoria> eventoCategorias = eventoCategoriaService.getAllEventoCategorias();
        return new ResponseEntity<>(eventoCategorias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoCategoria> getEventoCategoriaById(@PathVariable Long id) {
        EventoCategoria eventoCategoria = eventoCategoriaService.getEventoCategoriaById(id);
        if (eventoCategoria == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(eventoCategoria, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<EventoCategoria> createEventoCategoria(@RequestBody EventoCategoria eventoCategoria) {
        EventoCategoria novaEventoCategoria = eventoCategoriaService.createEventoCategoria(eventoCategoria);
        return new ResponseEntity<>(novaEventoCategoria, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoCategoria> updateEventoCategoria(@PathVariable Long id, @RequestBody EventoCategoria novaEventoCategoria) {
        EventoCategoria eventoCategoriaAtualizada = eventoCategoriaService.updateEventoCategoria(id, novaEventoCategoria);
        if (eventoCategoriaAtualizada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(eventoCategoriaAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEventoCategoria(@PathVariable Long id) {
        eventoCategoriaService.deleteEventoCategoria(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
