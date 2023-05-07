package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="tb_order")
public class Order implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//a partir da versão 8 para edição de data pode usar o Instant para data
	private Instant moment;
	
	//criar as asssociações varios pedidos tem um usário
	//@joincolumn passsar o nome da chave estrageira que vai ter no banco de dados
	@ManyToOne
	@JoinColumn(name="client_id")
	private User client;

	//criar os construtores com e sem argumentos
	
	public Order() {
		
	}

	public Order(Long id, Instant moment, User client) {
		
		this.id = id;
		this.moment = moment;
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
}
