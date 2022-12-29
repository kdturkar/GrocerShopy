package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class LoginRequest {
	
	private String email;
	private String password;
	
	public LoginRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
}
