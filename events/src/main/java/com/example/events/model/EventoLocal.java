package com.example.events.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class EventoLocal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Evento evento;
    
    @ManyToOne
    private Local local;
}
