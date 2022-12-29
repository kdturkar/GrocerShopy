package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Creates the addresses to save user address information
 * User can save many addresses 
 */

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"selectedUser"})

public class Address extends BaseEntity{
	@Column(name="address_line_1")
	private String addressLine1;
	
	@Column(name="address_line_2")
	private String addressLine2;
	
	@Column(length = 30)
	private String city;
	
	@Column(length = 10)
	private String pinCode;
	
	@Column(length = 30)
	private String state;
	
	@Column(length = 30)
	private String country;
	
	// Bidirectional Association
	@ManyToOne(fetch = FetchType.LAZY)		// Fetch the data lazily/ on demand
	@JoinColumn(name = "user_id",nullable = false)	// Create a table column in address table to store PK of user as FK.
	@JsonIgnore
	private User selectedUser;
	
	
	
	
	
}
