package com.masai.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer flatId;
	private String buildingName;
	@Max(10)
	private Integer noOfRooms;
	private LocalDate date_of_manufacturing;
	private String facing;
	private Integer price;
	private String description;
	
	
	
}



/*
 * Class Flat{
		FlatId; //autogenerated
		BuildingName;
    NoOfRooms: (add validation no should be less than 10)
    date_of_manufacturing: LocalDate (JSON Format)
    Facing: (East, West, Nort, South)
    price;
		description;
	}

//All the fields should be mandatory.

 * 
 */