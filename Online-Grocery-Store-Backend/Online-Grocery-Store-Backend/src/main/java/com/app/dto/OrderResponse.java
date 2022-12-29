package com.app.dto;

import java.util.List;

import com.app.pojos.Order;
import com.app.pojos.OrderDetail;
import com.app.pojos.Payment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderResponse {
	private Order order;
	private List<OrderDetail> orderDetails;
	private Payment payment;

	public OrderResponse(Order order, List<OrderDetail> orderDetails, Payment payment) {
		super();
		this.order = order;
		this.orderDetails = orderDetails;
		this.payment = payment;
	}
}
