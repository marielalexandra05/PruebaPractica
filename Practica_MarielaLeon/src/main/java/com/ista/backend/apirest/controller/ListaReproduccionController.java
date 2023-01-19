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

import com.ista.backend.apirest.modelo.ListaReproduccion;
import com.ista.backend.apirest.service.ListaReproduccionService;

@RestController
@RequestMapping("/api")
public class ListaReproduccionController {

	@Autowired
	   private ListaReproduccionService listaService;

	@GetMapping("/listarList")
 public ResponseEntity<List<ListaReproduccion>> obtenerLista() {
     return new ResponseEntity<>(listaService.findByAll(), HttpStatus.OK);
 }

 @PostMapping("/crearLista")
 public ResponseEntity<?> createUser (@RequestBody ListaReproduccion u) {
     return ResponseEntity.status(HttpStatus.CREATED).body(listaService.save(u));
 }

 @GetMapping("/{id}")
 public ResponseEntity<?> readUser (@PathVariable (value = "id") Integer id){
     Optional<ListaReproduccion> oUser = Optional.ofNullable(listaService.findById(id));

     if (!oUser.isPresent()){
         return ResponseEntity.notFound().build();
     }
     return ResponseEntity.ok(oUser);
 }

 @PutMapping("/updateLista/{id}")
 public ResponseEntity<?> updateUser (@RequestBody ListaReproduccion use, @PathVariable (value = "id") Integer id) {
     Optional<ListaReproduccion> us = Optional.ofNullable(listaService.findById(id));
     if (!us.isPresent()) {
         return ResponseEntity.notFound().build();
     }
         us.get().setDescription(use.getDescription());
        
         return ResponseEntity.status(HttpStatus.CREATED).body(listaService.save(us.get()));
 }
 
 @DeleteMapping("/EliminarLista/{id}")
 public ResponseEntity<?> deleteUser (@PathVariable (value = "id") Integer id) {
	 listaService.delete(id);
     return new ResponseEntity<>(HttpStatus.OK);
 }
	
	
	
}
