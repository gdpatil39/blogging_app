package com.blogger.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogger.exceptions.*;
import com.blogger.entity.User;
import com.blogger.payloads.UserDto;
import com.blogger.repositories.UserRepo;
import com.blogger.services.UserService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//private static final  logger=
	@Override
	public UserDto createUser(UserDto userDto) {
		log.info("Request in  create a new user with userid: {}",userDto);
		User user =this.dtoToUser(userDto);
		User saveUser = this.userRepo.save(user);
		return this.userToDto(saveUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
		User updateUser = this.userRepo.save(user);
		 UserDto userDto1 = this.userToDto(updateUser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user=this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		log.info("Request in  getAllUser ");
		List<User> users =this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		this.userRepo.delete(user);
	}
	
	private User dtoToUser(UserDto userDto) {
//		User user=new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
//		return user;
		
		
		User user=this.modelMapper.map(userDto, User.class);
		return user;
		
		
	}
	private UserDto userToDto(User user) {
//		UserDto userDto=new UserDto();
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setAbout(user.getAbout());
//		userDto.setPassword(user.getPassword());
		UserDto userDto=this.modelMapper.map(user, UserDto.class);
		return userDto;
		
	}

}
