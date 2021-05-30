package com.demo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.model.User;
import com.demo.springboot.repo.UserRepo;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("users")
@Log4j2
public class UserController {
	
	@Autowired
	private UserRepo userRepo;

	@GetMapping(value = "/one")
	public User findByParameter(@RequestBody User user) {
		log.info("Performing operation one " +user);
		return userRepo.findByFirstname(user.getFirstname());
	}
	
	@GetMapping(value = "/two")
	public User findByTwoParameters(@RequestBody User user) {
		log.info("Performing operation two " +user);
		return userRepo.findByFirstnameAndLastname(user.getFirstname(), user.getLastname());
	}
	
	@GetMapping(value = "/three")
	public User findByMultipleParameters(@RequestBody User user) {
		log.info("Performing operation three " +user);
		return userRepo.findByAgeAndActiveAndStartDate(user.getAge(), user.isActive(), user.getStartDate());
	}
	
}
