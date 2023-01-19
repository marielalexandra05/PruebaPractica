package com.ista.backend.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ista.backend.apirest.modelo.ListaReproduccion;

public interface ListaRepository extends JpaRepository<ListaReproduccion, Integer>{

}
