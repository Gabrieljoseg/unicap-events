package com.example.events.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class EventoCategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Evento evento;
    
    @ManyToOne
    private Categoria categoria;
}
