package com.masai.Service;

import com.masai.Exception.UserException;
import com.masai.Model.User;

public interface UserService {
	public User registerUser(User user)throws UserException;
}
