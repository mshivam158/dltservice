package com.dlt.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dlt.model.EOUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long primaryKey;
	private String username;
	private String password;
	
}
