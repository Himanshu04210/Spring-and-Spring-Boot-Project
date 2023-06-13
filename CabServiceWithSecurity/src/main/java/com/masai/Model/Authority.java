package com.masai.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Authority {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer authId;
	
	private String name;
	
	@JsonIgnore
	@ManyToOne
	private Users user;
}
