package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * Serializable transformado em cadeias de byte assim permite que o obj trafegue
	 * na rede o objeto pode ser gravados em arquivos
	 */
//primeiro passo: criar os atributos basicos
//segundo passo: associações(nesse caso n tá usando)
//terceiro passo: construtores
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;

	// associação, um usuário para vários pedidos
	// instanciar as coleções
	// se for uma coleção utilizada apenas o get
	//jsonignore para evitar a repetição infinita
	//Lazy loading so correga o entidade sem associação
	
	//Uma categoria pode ter varios produtos
	//joinTable(passar o nome da tabela e as chaves estrangeiras q vai associar a tabela
	//de produto com tabela de categoria
	//nome chave estrageira referente ao produto
	//inverseJoinColumns define a chave estrageira da outra entidade
	@ManyToMany
	@JoinTable(name="tb_product_category",
	joinColumns=@JoinColumn(name="product_id"),
	inverseJoinColumns=@JoinColumn(name ="category_id"))
	private Set<Category> category = new HashSet<>();
	//o id ta ao ordemItem instacia de ordemItemPK
	//em relação a ordemItemPK
	@OneToMany(mappedBy= "id.product")
	private Set<OrderItem> items = new HashSet<>();

	public Product() {

	}
	
	

	public Product(Long id, String name, String description, Double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}



	public Set<Category> getCategory() {
		return category;
	}
	

	@JsonIgnore
	public Set<Order> getOrders(){
		Set<Order>set = new HashSet<>();
		
		for(OrderItem x: items) {
			set.add(x.getOrder());
		}
		return set;
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
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}