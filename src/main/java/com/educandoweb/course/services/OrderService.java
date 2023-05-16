package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;

import com.educandoweb.course.repositeries.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;
	//operação na camada de serviço que passa para o repositorio
	public List<Order> findAll(){
		return repository.findAll();
		
	}
	
	public Order findById(long id) {
		Optional<Order> obj =repository.findById(id);
		return obj.get();
	}
	
}
