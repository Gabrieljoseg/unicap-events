package com.example.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoCategoriaRepository extends JpaRepository<EventoCategoria, Long> {
}
