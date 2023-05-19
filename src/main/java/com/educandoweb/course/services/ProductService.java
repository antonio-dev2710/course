package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositeries.ProductRepository;
//vai poder ser injetado com o autoweired @Component
//registrar o servico na camada de servico

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	//operação na camada de serviço que passa para o repositorio
	public List<Product> findAll(){
		return repository.findAll();
		
	}
	
	public Product findById(long id) {
		Optional<Product> obj =repository.findById(id);
		return obj.get();
	}
	
}
