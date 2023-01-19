package com.ista.backend.apirest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ista.backend.apirest.modelo.Cancion;
import com.ista.backend.apirest.service.CancionService;


@RestController
@RequestMapping("/api")
public class CancionController {
	
	@Autowired
	   private CancionService cancionService;

	@GetMapping("/listaCancion")
    public ResponseEntity<List<Cancion>> obtenerLista() {
        return new ResponseEntity<>(cancionService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crearCancion")
    public ResponseEntity<?> createUser (@RequestBody Cancion u) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cancionService.save(u));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readUser (@PathVariable (value = "id") Integer id){
        Optional<Cancion> oUser = Optional.ofNullable(cancionService.findById(id));

        if (!oUser.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oUser);
    }

    @PutMapping("/updateCancion/{id}")
    public ResponseEntity<?> updateUser (@RequestBody Cancion use, @PathVariable (value = "id") Integer id) {
        Optional<Cancion> us = Optional.ofNullable(cancionService.findById(id));
        if (!us.isPresent()) {
            return ResponseEntity.notFound().build();
        }
            us.get().setTitulo(use.getTitulo());
            us.get().setArtista(use.getArtista());
            us.get().setAlbum(use.getAlbum());
            us.get().setAnio(use.getAnio());
            
            return ResponseEntity.status(HttpStatus.CREATED).body(cancionService.save(us.get()));
    }
    
    @DeleteMapping("/EliminarCancion/{id}")
    public ResponseEntity<?> deleteUser (@PathVariable (value = "id") Integer id) {
    	cancionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
