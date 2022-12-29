package com.app.dto;

import com.app.pojos.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class LoginResponse {
	private String status;
	private User data;
	private String token;
	
	
	
	public LoginResponse(String status, User user, String token) {
		System.out.println("\n----------- CTOR: LoginResponse - generating response with user details --------------\n");
		this.status = status;
		this.data = user;
		this.token = token;
	}
}
