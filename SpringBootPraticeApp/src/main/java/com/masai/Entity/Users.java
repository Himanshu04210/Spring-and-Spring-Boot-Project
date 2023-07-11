package com.masai.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Users {
	private Integer userId;
	
	private String userName;
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Orders orders;
}	
