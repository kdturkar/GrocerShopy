package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Creates the user_table to save user information
 */

@Entity					// Notify SC to manage the life-cycle of following type
@Table(name = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User extends BaseEntity{	
	
	@Column(name = "first_name",length = 30)
	private String firstName;
	
	@Column(name = "last_name",length = 30)
	private String lastName;
	
	@Column(unique= true)
	@NotBlank(message = "email is required")
	@Email(message = "invalid email format")
    private String email;
	
	@Column(nullable = false)
	
	//@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message = "Blank or Invalid password")
	private String password;
	
	
	@NotBlank(message = "Phone no is required")
	
	private String phoneNumber;
	
	
	@Enumerated(EnumType.STRING)		// Specifies the Role as String data-type in database 
	private Role role;
	
	
	
	
	
	
}
