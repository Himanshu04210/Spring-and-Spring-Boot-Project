package com.masai.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;


@Entity
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
	
	
	
	public Flat() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	public Flat(Integer flatId, String buildingName, @Max(10) Integer noOfRooms, LocalDate date_of_manufacturing,
			String facing, Integer price, String description) {
		super();
		this.flatId = flatId;
		this.buildingName = buildingName;
		this.noOfRooms = noOfRooms;
		this.date_of_manufacturing = date_of_manufacturing;
		this.facing = facing;
		this.price = price;
		this.description = description;
	}




	public Integer getFlatId() {
		return flatId;
	}




	public void setFlatId(Integer flatId) {
		this.flatId = flatId;
	}




	public String getBuildingName() {
		return buildingName;
	}




	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}




	public Integer getNoOfRooms() {
		return noOfRooms;
	}




	public void setNoOfRooms(Integer noOfRooms) {
		this.noOfRooms = noOfRooms;
	}




	public LocalDate getDate_of_manufacturing() {
		return date_of_manufacturing;
	}




	public void setDate_of_manufacturing(LocalDate date_of_manufacturing) {
		this.date_of_manufacturing = date_of_manufacturing;
	}




	public String getFacing() {
		return facing;
	}




	public void setFacing(String facing) {
		this.facing = facing;
	}




	public Integer getPrice() {
		return price;
	}




	public void setPrice(Integer price) {
		this.price = price;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	@Override
	public String toString() {
		return "Flat [flatId=" + flatId + ", buildingName=" + buildingName + ", noOfRooms=" + noOfRooms
				+ ", date_of_manufacturing=" + date_of_manufacturing + ", facing=" + facing + ", price=" + price
				+ ", description=" + description + "]";
	}
	
	
	
	
	
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