package com.masai.Entity;

import java.util.List;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Truck {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer truckId;
	
	@NonNull
	@NotBlank(message = "Please enter a valid truck number")
	private Integer truckNumber;
	
	@OneToOne
	@JoinColumn(name = "Id")
	private Users users;
	
	
}
