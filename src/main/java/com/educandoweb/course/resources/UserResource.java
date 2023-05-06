package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

//classe web que é implementada por um controlador rest
//precisa dar um nome para o recurso

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	// criar um endpoint para acessar os usuários
	// responde a requisicao get do http
	// ResponseEntity<User> é um tipo de classe usado em APIs REST
	// em Java para representar a resposta HTTP de uma solicitação

	// dependencia para o service
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		// chamar o meu serviso
		List<User> listUse = service.findAll();
		return ResponseEntity.ok().body(listUse);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
