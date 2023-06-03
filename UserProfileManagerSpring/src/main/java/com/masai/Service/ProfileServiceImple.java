package com.masai.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.ProfileException;
import com.masai.Exception.UserException;
import com.masai.Model.Profile;
import com.masai.Model.User;
import com.masai.Repository.ProfileRepository;
import com.masai.Repository.UserRepository;

@Service
public class ProfileServiceImple implements ProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private UserRepository userRepository;
	
	public Profile registerProfile(Profile profile) throws ProfileException, UserException{
		
//		Optional<Profile> opt = profileRepository.findById(profile.getId());
//		
//		if(opt.isPresent()) throw new ProfileException("profile is already in database");
//		
//		Optional<User> opt1 = userRepository.findById(profile.getUser().getId());
//		
//		if(opt1.isPresent()) throw new UserException("User is already present");
//		
//		User user = profile.getUser();
//		System.out.println(user);

//		user.setProfile(profile);
		
		
		
		System.out.println(profile.getId());
		
		profileRepository.save(profile);	
		return profile;
	}
}
