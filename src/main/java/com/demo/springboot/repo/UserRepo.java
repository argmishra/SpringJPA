package com.demo.springboot.repo;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springboot.model.User;

public interface UserRepo extends JpaRepository<User, Long>{

	User findByFirstname(String firstname);

	User findByFirstnameAndLastname(String firstname, String lastname);
	
	User findByAgeAndActiveAndStartDate(int age, boolean active, Date date);

}
