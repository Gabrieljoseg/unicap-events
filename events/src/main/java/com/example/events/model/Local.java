package com.example.events.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String endereco;
    
    @OneToMany(mappedBy = "local")
    private Set<EventoLocal> eventos = new HashSet<>();
}
