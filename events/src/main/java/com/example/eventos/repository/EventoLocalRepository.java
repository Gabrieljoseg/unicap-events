package com.example.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoLocalRepository extends JpaRepository<EventoLocal, Long> {
}
