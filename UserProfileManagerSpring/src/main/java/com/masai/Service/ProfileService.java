package com.masai.Service;

import com.masai.Exception.ProfileException;
import com.masai.Exception.UserException;
import com.masai.Model.Profile;

public interface ProfileService {
	public Profile registerProfile(Profile profile) throws ProfileException, UserException;
}
