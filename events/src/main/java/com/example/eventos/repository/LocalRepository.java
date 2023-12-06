package com.example.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.eventos.model.*;


@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {
}
