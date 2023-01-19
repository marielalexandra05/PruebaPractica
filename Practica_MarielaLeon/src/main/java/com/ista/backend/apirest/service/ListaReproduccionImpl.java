package com.ista.backend.apirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


import com.ista.backend.apirest.modelo.ListaReproduccion;

import com.ista.backend.apirest.repository.ListaRepository;

@Service
public class ListaReproduccionImpl extends GenericServiceImpl<ListaReproduccion, Integer> implements ListaReproduccionService{

	@Autowired
    ListaRepository listaRepository;
	
	@Override
	public CrudRepository<ListaReproduccion, Integer> getDao() {
		return listaRepository;
	}
}
