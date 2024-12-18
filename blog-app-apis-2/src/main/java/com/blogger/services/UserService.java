package com.blogger.services;

import java.util.List;

import com.blogger.entity.User;
import com.blogger.payloads.UserDto;

public interface UserService {

	
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user ,Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);
	
	
}
