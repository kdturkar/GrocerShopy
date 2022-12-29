package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="stock")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"currentProduct"})
public class Stock extends BaseEntity {
	
	private int quantity;
	@Column(length=10)
	private String unit;
	@OneToOne
	@JoinColumn(name="product_id")
	@MapsId
	private Product currentProduct;
	
	

	public Stock(int quantity, String unit) {
		super();
		this.quantity = quantity;
		this.unit = unit;
	}

	

	
}