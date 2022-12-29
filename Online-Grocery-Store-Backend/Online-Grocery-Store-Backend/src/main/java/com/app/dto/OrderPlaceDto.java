package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderPlaceDto {
	private String paymentMode; 
	private int addressId;

	public OrderPlaceDto(String paymentMode, int addressId) {
		super();
		this.paymentMode = paymentMode;
		this.addressId = addressId;
	}
}
