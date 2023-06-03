package com.masai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.masai.Exception.UserException;
import com.masai.Model.Profile;
import com.masai.Model.User;
import com.masai.Repository.ProfileRepository;
import com.masai.Repository.UserRepository;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private UserRepository userRepository;
	@Override
	public User registerUser(User user) throws UserException {
		Profile profile = user.getProfile();
        profile.setUser(user);

        User savedUser = userRepository.save(user);
        return savedUser;
	}

}
