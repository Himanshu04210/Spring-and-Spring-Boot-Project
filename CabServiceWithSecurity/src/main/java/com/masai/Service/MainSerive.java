package com.masai.Service;

import java.util.List;

import com.masai.Exception.TruckException;
import com.masai.Exception.UserException;
import com.masai.Model.Truck;
import com.masai.Model.Users;

public interface MainSerive {

	public Users registerUser(Users user) throws UserException; 
	public List<Truck> getAllTruck() throws UserException, TruckException;
	
	public Truck getTruckByEmail(String email) throws UserException, TruckException;
	
	
}
