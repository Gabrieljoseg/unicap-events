package com.example.eventos.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Evento evento;
    
    @ManyToOne
    private Estudante estudante;
}
