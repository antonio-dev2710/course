package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositeries.UserRepository;
import com.educandoweb.course.services.exceptions.DataBaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
	  return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			//lançando uma exceção da minha camada de servico
			throw new DataBaseException(e.getMessage());
		}
		
	}
	
	public User update(Long id, User obj) {
		//prepara o bojeto monitorado para vc mexer e 
		//dps executa uma operação
		User entity = repository.getReferenceById(id);
		UpdateData(entity,obj);
		
		return repository.save(entity);
	}

	private void UpdateData(User entity, User obj) {
		
		//atualizar os dados dos entity com base oq chegou do obj
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
	
}
