package com.masai.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Truck {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer truckId;
	
	@NotNull(message = "Number should not be null")
	@NotBlank(message = "number should not be blank")
	private String truckNumber;
	
	@OneToOne
	@JoinColumn(name = "userId")
	private Users user;
	
}
