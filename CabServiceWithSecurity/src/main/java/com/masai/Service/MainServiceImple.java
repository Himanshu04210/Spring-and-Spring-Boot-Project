package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.TruckException;
import com.masai.Exception.UserException;
import com.masai.Model.Truck;
import com.masai.Model.Users;
import com.masai.Repository.TruckRepository;
import com.masai.Repository.UserRepository;


@Service
public class MainServiceImple implements MainSerive{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TruckRepository truckRepository;
	
	
	@Override
	public Users registerUser(Users user) throws UserException {
		// TODO Auto-generated method stub
		if(user == null) throw new UserException("Object is null");
		
		try {
			
			Optional<Users> u = userRepository.findByEmail(user.getEmail());
			
			if(u.isPresent()) throw new UserException("User is already present");
			
			 Users savedUser = userRepository.save(user);
			 
			 return savedUser;
			
			
		}
		catch(Exception e) {
			throw new UserException("Something went wrong " + e.getMessage());
		}
		
	}

	@Override
	public List<Truck> getAllTruck() throws UserException, TruckException {
		List<Truck> trucks = truckRepository.findAll();
		
		if(trucks.isEmpty()) throw new TruckException("No truck is availble");
		
		return trucks;
	}

	@Override
	public Truck getTruckByEmail(String email) throws UserException, TruckException {
		
		Optional<Users> user = userRepository.findByEmail(email);
		if(user.isEmpty()) throw new UserException("User is not present");
		
		Truck truck = user.get().getTruck();
		if(truck == null) throw new TruckException("truck is not present with this user");
		
		return truck;
	}
	
}
