package com.ista.backend.apirest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


import com.ista.backend.apirest.modelo.Cancion;
import com.ista.backend.apirest.repository.CancionRepository;


@Service
public class CancionServiceImpl extends GenericServiceImpl<Cancion, Integer> implements CancionService{

	@Autowired
    CancionRepository cancionRepository;
	
	@Override
	public CrudRepository<Cancion, Integer> getDao() {
		return cancionRepository;
	}
}
