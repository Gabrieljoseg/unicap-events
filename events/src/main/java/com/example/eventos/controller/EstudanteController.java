package com.example.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.eventos.service.*;
import com.example.eventos.model.*;

import java.util.List;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {
    private final EstudanteService estudanteService;

    @Autowired
    public EstudanteController(EstudanteService estudanteService) {
        this.estudanteService = estudanteService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Estudante>> getAllEstudantes() {
        List<Estudante> estudantes = estudanteService.getAllEstudantes();
        return new ResponseEntity<>(estudantes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudante> getEstudanteById(@PathVariable Long id) {
        Estudante estudante = estudanteService.getEstudanteById(id);
        if (estudante == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(estudante, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Estudante> createEstudante(@RequestBody Estudante estudante) {
        Estudante novoEstudante = estudanteService.createEstudante(estudante);
        return new ResponseEntity<>(novoEstudante, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudante> updateEstudante(@PathVariable Long id, @RequestBody Estudante novoEstudante) {
        Estudante estudanteAtualizado = estudanteService.updateEstudante(id, novoEstudante);
        if (estudanteAtualizado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(estudanteAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudante(@PathVariable Long id) {
        estudanteService.deleteEstudante(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
