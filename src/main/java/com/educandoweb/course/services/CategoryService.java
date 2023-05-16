package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositeries.CategoryRepository;
//vai poder ser injetado com o autoweired @Component
//registrar o servico na camada de servico

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repository;
	//operação na camada de serviço que passa para o repositorio
	public List<Category> findAll(){
		return repository.findAll();
		
	}
	
	public Category findById(long id) {
		Optional<Category> obj =repository.findById(id);
		return obj.get();
	}
	
}
