package com.app.pojos;

import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="orders")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"deliveryAddress","customer"})

public class Order extends BaseEntity {
	
	@Column(name="total_price")
	private double totalPrice;
	
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@Column(name="order_date")
	private LocalDateTime orderDate;
	
	@Enumerated(EnumType.STRING)
	@Column(length=25,name="order_status")
	private OrderStatus orderStatus;
	
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@Column(name="status_update_date")
	private LocalDateTime statusUpdateDate;
	
	@OneToOne
	@JoinColumn(name="delivery_address_id")
	private Address deliveryAddress;
	
	@ManyToOne
	@JoinColumn(name="customer_id",nullable = false)
	private User customer;
	
	

	

	

	public Order(double totalPrice, LocalDateTime orderDate, OrderStatus orderStatus, LocalDateTime statusUpdateDate,
			Address deliveryAddress, User customer) {
		super();
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.statusUpdateDate = statusUpdateDate;
		this.deliveryAddress = deliveryAddress;
		this.customer = customer;
		
	}



	

	


	
}
