package com.example.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.eventos.service.*;
import com.example.eventos.model.*;

import java.util.List;

@RestController
@RequestMapping("/locais")
public class LocalController {
    private final LocalService localService;

    @Autowired
    public LocalController(LocalService localService) {
        this.localService = localService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Local>> getAllLocais() {
        List<Local> locais = localService.getAllLocais();
        return new ResponseEntity<>(locais, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Local> getLocalById(@PathVariable Long id) {
        Local local = localService.getLocalById(id);
        if (local == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(local, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Local> createLocal(@RequestBody Local local) {
        Local novoLocal = localService.createLocal(local);
        return new ResponseEntity<>(novoLocal, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Local> updateLocal(@PathVariable Long id, @RequestBody Local novoLocal) {
        Local localAtualizado = localService.updateLocal(id, novoLocal);
        if (localAtualizado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(localAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocal(@PathVariable Long id) {
        localService.deleteLocal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
