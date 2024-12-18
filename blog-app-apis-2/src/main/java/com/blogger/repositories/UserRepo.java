package com.blogger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogger.entity.User;



public interface UserRepo extends JpaRepository<User, Integer>{

}
