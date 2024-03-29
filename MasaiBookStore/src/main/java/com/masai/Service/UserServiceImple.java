package com.masai.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.CurrentUserSession;
import com.masai.DTO.LongInCrede;
import com.masai.Exception.UserException;
import com.masai.Model.User;
import com.masai.Repository.SessionRepo;
import com.masai.Repository.UserRepository;

@Service
public class UserServiceImple implements UserService {
	
	@Autowired
	private UserRepository  userRepository;
	@Autowired
	private SessionRepo sRepo;
	@Override
	public User RegisterUser(User user) throws UserException {
		if(user == null) throw new UserException("object is null");
		User savedUser = userRepository.save(user);
		return savedUser;
	}
	
	@Override
	public String logIn(LongInCrede crede) throws UserException {
		User user = userRepository.findByUsername(crede.getUsername());
		
		if(user == null) throw new UserException("Username is not matched");
		

		Optional<CurrentUserSession> validCustomerSessionOpt =  sRepo.findById(user.getUserId());
		
		
		if(validCustomerSessionOpt.isPresent()) {
			
			throw new UserException("User already Logged In with this username");
			
		}
		
		if(user.getPassword().equals(crede.getPassword())) {
			String key = null;
			System.out.println(user.getRole());
			if(user.getRole().toString().equals("ADMIN")) 
				key =generateRandomString(8);
			
			else key = generateRandomString(6);
			
			CurrentUserSession currentUserSession = new CurrentUserSession(user.getUserId(),key,LocalDateTime.now());
			
			sRepo.save(currentUserSession);

			return currentUserSession.toString();
		}
		else
			throw new UserException("Please Enter a valid password");
		
	}
	
	public String logOutFromAccount(String key)throws UserException {
		
		CurrentUserSession validCustomerSession = sRepo.findByUuid(key);
		
		
		if(validCustomerSession == null) {
			throw new UserException("User Not Logged In with this username");
			
		}
		
		
		sRepo.delete(validCustomerSession);
		
		
		return "Logged Out !";
		
		
	}
	
	public static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }

	@Override
	public List<User> getAllUsers(String key) throws UserException {
		

		CurrentUserSession validCustomerSession = sRepo.findByUuid(key);
		
		if(validCustomerSession == null) {
			throw new UserException("User Not Logged In with this username");
			
		}
		if(key.length()<8) throw new UserException("Role should be admin for adding a book");
		
		List<User> users= userRepository.findAll();

		if(users.isEmpty()) throw new UserException("No user is present");

		return users;


	}

}
