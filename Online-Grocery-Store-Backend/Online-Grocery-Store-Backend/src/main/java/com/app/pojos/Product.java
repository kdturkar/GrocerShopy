package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"selectedCategory"})
public class Product extends BaseEntity{
	@Column(length=30)
	private String name;
	@Column(length=100)
	private String description;
	private double price;
	
	@Column(length = 400)
	private String imagePath;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private Status status;
	
	@ManyToOne
	@JoinColumn(name = "category_id",nullable = false)
	@JsonIgnoreProperties("products")
	private Category selectedCategory;
	
	

	public Product(String name, String description, double price, Status status) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.status = status;
	}

	
	
	

	
}
