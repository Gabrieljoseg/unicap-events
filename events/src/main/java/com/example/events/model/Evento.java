package com.example.events.model; 

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
}
