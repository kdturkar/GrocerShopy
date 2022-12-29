package com.app.dto;

import com.app.pojos.Product;
import com.app.pojos.Stock;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductDto {
	private Product product;
	private String category;
	private Stock stock;
	
	
	public ProductDto(Product product, String category, Stock stock) {
		super();
		this.product = product;
		this.category = category;
		this.stock = stock;
	}
}
