package com.example.events.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
@Entity
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String email;
    
    @OneToMany(mappedBy = "estudante")
    private Set<Inscricao> inscricoes = new HashSet<>();
}
