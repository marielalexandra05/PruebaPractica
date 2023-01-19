package com.ista.backend.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ista.backend.apirest.modelo.Cancion;

public interface CancionRepository extends JpaRepository<Cancion, Integer>{

}
