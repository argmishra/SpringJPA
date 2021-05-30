package com.demo.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springboot.model.User;

public interface UserRepo extends JpaRepository<User, Long>{

	User findByFirstname(String firstname);

	User findByFirstnameAndLastname(String firstname, String lastname);

}
