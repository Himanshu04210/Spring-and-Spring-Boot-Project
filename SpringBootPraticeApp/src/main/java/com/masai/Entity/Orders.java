package com.masai.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	
	private String product;
	
	private double amount;
	
	@JsonIgnore
	@ManyToOne
	private Users user;
}
