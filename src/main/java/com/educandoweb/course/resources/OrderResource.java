package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

//classe web que é implementada por um controlador rest
//precisa dar um nome para o recurso

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	// criar um endpoint para acessar os usuários
	// responde a requisicao get do http
	// ResponseEntity<Order> é um tipo de classe usado em APIs REST
	// em Java para representar a resposta HTTP de uma solicitação

	// dependencia para o service
	@Autowired
	private OrderService service;

	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		// chamar o meu serviso
		List<Order> listUse = service.findAll();
		return ResponseEntity.ok().body(listUse);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
