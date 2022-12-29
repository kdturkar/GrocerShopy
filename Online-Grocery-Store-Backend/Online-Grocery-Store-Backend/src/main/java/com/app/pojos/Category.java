package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"products"})
public class Category extends BaseEntity {
	
	@Column(length = 30)
	private String name;
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private Status status;
	
	@OneToMany(mappedBy = "selectedCategory",cascade = {CascadeType.MERGE,CascadeType.REMOVE},orphanRemoval = true)
	@JsonIgnoreProperties("selectedCategory")
	@JsonIgnore
	private List<Product> products = new ArrayList<>();
	

	public Category(String name, Status status) {
		super();
		this.name = name;
		this.status = status;
	}

	
	
	
	public void addProduct(Product p)
	{
		products.add(p);
		p.setSelectedCategory(this);
	}
	
	public void removeProduct(Product p)
	{
		products.remove(p);
		p.setSelectedCategory(null);
	}	

	
	
	
}
