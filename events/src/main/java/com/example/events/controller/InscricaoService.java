package com.example.events.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {
    private final InscricaoService inscricaoService;

    @Autowired
    public InscricaoController(InscricaoService inscricaoService) {
        this.inscricaoService = inscricaoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Inscricao>> getAllInscricoes() {
        List<Inscricao> inscricoes = inscricaoService.getAllInscricoes();
        return new ResponseEntity<>(inscricoes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscricao> getInscricaoById(@PathVariable Long id) {
        Inscricao inscricao = inscricaoService.getInscricaoById(id);
        if (inscricao == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(inscricao, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Inscricao> createInscricao(@RequestBody Inscricao inscricao) {
        Inscricao novaInscricao = inscricaoService.createInscricao(inscricao);
        return new ResponseEntity<>(novaInscricao, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inscricao> updateInscricao(@PathVariable Long id, @RequestBody Inscricao novaInscricao) {
        Inscricao inscricaoAtualizada = inscricaoService.updateInscricao(id, novaInscricao);
        if (inscricaoAtualizada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(inscricaoAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInscricao(@PathVariable Long id) {
        inscricaoService.deleteInscricao(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

