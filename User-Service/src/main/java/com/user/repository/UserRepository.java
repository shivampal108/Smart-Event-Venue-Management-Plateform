package com.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);
	
}
