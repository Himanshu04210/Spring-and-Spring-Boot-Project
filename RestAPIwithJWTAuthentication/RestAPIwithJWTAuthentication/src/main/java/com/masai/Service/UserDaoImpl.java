package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.Entity.Truck;
import com.masai.Entity.Users;
import com.masai.Exception.TruckException;
import com.masai.Exception.UserException;
import com.masai.Repository.TruckRepository;
import com.masai.Repository.UserRepository;

public class UserDaoImpl implements UserDao{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TruckRepository truckRepository;
	
	@Override
	public List<Truck> getAllTruck() throws TruckException {
		// TODO Auto-generated method stub
		List<Truck> trucks = truckRepository.findAll();
		if(trucks.isEmpty()) throw new TruckException("No trucks found");
		return trucks;
	}

	@Override
	public Truck findTruckByUserId(Integer id) throws TruckException{
		// TODO Auto-generated method stub
		Optional<Users> opt = userRepository.findById(id);
		if(opt.isPresent()) {
			Users users = opt.get();
			return users.getTruck();
		}
		throw new TruckException("No user found by UserID:- "+id);
	}

	@Override
	public Users createNewUser(Users users) throws UserException{
		// TODO Auto-generated method stub
		if(users == null) throw new UserException("Input mis-match");
		try {
			Optional<Users> opt = userRepository.findByEmail(users.getEmail());
			if(opt.isPresent()) {
				Users user2 = opt.get();				
				Users user3 = userRepository.save(user2);
				return user3;
			}
			throw new UserException("Input mis-match");
		}
		catch (Exception e) {
			// TODO: handle exception
			throw new UserException(e.getMessage());
		}
		
	}

}
