package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

//classe web que é implementada por um controlador rest
//precisa dar um nome para o recurso

@RestController
@RequestMapping(value ="/users")
public class UserResource {
		//criar um endpoint para acessar os usuários
	//responde a requisicao get do http
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "12443-45","345523w");
		return ResponseEntity.ok().body(u);
		
		
	}
}
