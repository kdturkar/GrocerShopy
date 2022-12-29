package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseDto<T> {
	private String status;
	private T data;
	
	public ResponseDto(String status, T data) {
		super();
		this.status = status;
		this.data = data;
	}

}
