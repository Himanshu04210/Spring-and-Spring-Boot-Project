package com.masai.Service;

import com.masai.Entity.Users;

public interface UserService {
	public Users registerUser(Users user);
	public Users getUserById(Integer userId);
}
