package com.app.pojos;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/*
 *  BaseEntity is super type of all Entity types
 *  Id field is primary key of all the entities that inherits from this class
 *  The ID value is also assigned by strategy Identity equivalent to auto increment in MySQL
 */


@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
}
