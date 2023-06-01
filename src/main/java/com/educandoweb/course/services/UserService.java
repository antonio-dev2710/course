package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositeries.UserRepository;
//vai poder ser injetado com o autoweired @Component
//registrar o servico na camada de servico

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	//operação na camada de serviço que passa para o repositorio
	public List<User> findAll(){
		return repository.findAll();
		
	}
	
	public User findById(long id) {
		Optional<User> obj =repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
	  return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}
