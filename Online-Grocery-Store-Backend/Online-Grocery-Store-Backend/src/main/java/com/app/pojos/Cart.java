package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="cart")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"selectedProduct","currentCustomer"})
public class Cart extends BaseEntity{
	
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product selectedProduct;
	
	@OneToOne
	@JoinColumn(name="customer_id")
	@JsonIgnore
	private User currentCustomer;

	

	public Cart(int quantity, Product selectedProduct, User currentCustomer) {
		super();
		this.quantity = quantity;
		this.selectedProduct = selectedProduct;
		this.currentCustomer = currentCustomer;
	}

	

	
	
}
