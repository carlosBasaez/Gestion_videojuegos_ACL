package com.gestion.juegos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.juegos.modelo.Juego;

@Repository
public interface JuegoRepositorio extends JpaRepository<Juego, Long>{

	
}
