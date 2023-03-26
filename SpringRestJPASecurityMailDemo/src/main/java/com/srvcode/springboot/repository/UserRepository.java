package com.srvcode.springboot.repository;

import org.springframework.stereotype.Repository;

import com.srvcode.springboot.model.User;

import org.springframework.data.repository.CrudRepository;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
	
	User findByConfirmationToken(String confirmationToken);
}
