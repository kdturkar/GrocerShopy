package com.app.pojos;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="order_details")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"currentOrder","selectedProduct"})
public class OrderDetail extends BaseEntity{
	private double price;
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name="order_id",nullable = false)
	@JsonIgnore
	private Order currentOrder;
	
	@ManyToOne
	@JoinColumn(name="product_id",nullable = false)
	private Product selectedProduct;
	
	

	public OrderDetail(double price, int quantity, Order currentOrder, Product selectedProduct) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.currentOrder = currentOrder;
		this.selectedProduct = selectedProduct;
	}

	

	
	

	
	
	
}
