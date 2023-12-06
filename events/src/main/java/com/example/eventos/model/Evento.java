package com.example.eventos.model; 

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String descricao;
    
    @OneToMany(mappedBy = "evento")
    private Set<Inscricao> inscricoes = new HashSet<>();
    
    @OneToMany(mappedBy = "evento")
    private Set<EventoCategoria> categorias = new HashSet<>();
    
    @OneToMany(mappedBy = "evento")
    private Set<EventoLocal> locais = new HashSet<>();
    
    // Add constructors, getters, and setters here
    
    // Add any additional methods here
}
