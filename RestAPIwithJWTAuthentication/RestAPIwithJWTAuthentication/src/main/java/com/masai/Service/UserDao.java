package com.masai.Service;

import java.util.List;

import com.masai.Entity.Truck;
import com.masai.Entity.Users;
import com.masai.Exception.TruckException;
import com.masai.Exception.UserException;

public interface UserDao {

	public List<Truck> getAllTruck() throws TruckException;
	public Truck findTruckByUserId(Integer id) throws TruckException;
	public Users createNewUser(Users users) throws UserException;
	
}
