package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	// vai ser enviado um objeto json com os campos do usário
	// o response mais indicado pra dizer q foi criado um novo recurso é o 201
	// metodo criated é esperado um cabeçalho chamado location cotendo o nuvo rcurso
	// que foi inserido

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);

	}
	//void porque a resposta dessa requisição 
	//n vai voltar nenhum corpo
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
