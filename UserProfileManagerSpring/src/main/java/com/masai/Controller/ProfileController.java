package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.ProfileException;
import com.masai.Exception.UserException;
import com.masai.Model.Profile;
import com.masai.Service.ProfileService;

@RestController

public class ProfileController {
	@Autowired
	private ProfileService profileService;
	
	@PostMapping("/profile")
	public ResponseEntity<Profile> registereprofile(@RequestBody Profile profile) throws ProfileException, UserException {
		profileService.registerProfile(profile);
		
		return new ResponseEntity<Profile>(profile, HttpStatus.OK);
	}

}
