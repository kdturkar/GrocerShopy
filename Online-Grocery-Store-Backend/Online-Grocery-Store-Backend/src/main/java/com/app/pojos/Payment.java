package com.app.pojos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="payments")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"currentOrder"})
public class Payment extends BaseEntity{
	
	private double amount;
	
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@Column(name="payment_date")
	private LocalDateTime paymentDate;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 12)
	private PaymentStatus status;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 12)
	private Type type;
	
	@OneToOne
	@JoinColumn(name="order_id")
	@JsonIgnore
	private Order currentOrder;
	
	

	public Payment(double amount, LocalDateTime paymentDate, PaymentStatus status, Type type, Order currentOrder) {
		super();
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.status = status;
		this.type = type;
		this.currentOrder = currentOrder;
	}

	

	
	
}
