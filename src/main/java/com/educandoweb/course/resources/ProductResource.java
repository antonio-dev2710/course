package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;

//classe web que é implementada por um controlador rest
//precisa dar um nome para o recurso

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	// criar um endpoint para acessar os usuários
	// responde a requisicao get do http
	// ResponseEntity<Product> é um tipo de classe usado em APIs REST
	// em Java para representar a resposta HTTP de uma solicitação

	// dependencia para o service
	@Autowired
	private ProductService service;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		// chamar o meu serviso
		List<Product> listUse = service.findAll();
		return ResponseEntity.ok().body(listUse);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
