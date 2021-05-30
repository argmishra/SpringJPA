package com.demo.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public User findByTwoParametersWithAnd(@RequestBody User user) {
		log.info("Performing operation two " +user);
		return userRepo.findByFirstnameAndLastname(user.getFirstname(), user.getLastname());
	}
	
	@GetMapping(value = "/three")
	public User findByMultipleParametersWithAnd(@RequestBody User user) {
		log.info("Performing operation three " +user);
		return userRepo.findByAgeAndActiveAndStartDate(user.getAge(), user.isActive(), user.getStartDate());
	}
	
	@GetMapping(value = "/four")
	public List<User> findByMultipleParametersWithOr(@RequestBody User user) {
		log.info("Performing operation four " +user);
		return userRepo.findByAgeOrActiveOrFirstname(user.getAge(), user.isActive(), user.getFirstname());
	}
	
	@GetMapping(value = "/five")
	public List<User> findByMultipleParametersWithAndOr(@RequestBody User user) {
		log.info("Performing operation five " +user);
		return userRepo.findByAgeOrActiveAndFirstname(user.getAge(), user.isActive(), user.getFirstname());
	}
	
	@GetMapping(value = "/six")
	public List<User> findByMultipleParametersIs(@RequestBody User user) {
		log.info("Performing operation six " +user);
		return userRepo.findByAgeOrActiveIs(user.getAge(), user.isActive());
	}
	
	@GetMapping(value = "/seven")
	public List<User> findByMultipleParametersEquals(@RequestBody User user) {
		log.info("Performing operation seven " +user);
		return userRepo.findByAgeOrActiveEquals(user.getAge(), user.isActive());
	}
	
	@GetMapping(value = "/eight")
	public List<User> findByBetween(@RequestParam(name = "start") int startAge, @RequestParam(name = "end") int endAge) {
		log.info("Performing operation eight : start date " +startAge + " and end date " +endAge);
		return userRepo.findByAgeBetween(startAge, endAge);
	}
	
	@GetMapping(value = "/nine/{age}")
	public List<User> findByLessThan(@PathVariable(name = "age") int age) {
		log.info("Performing operation nine : age " + age );
		return userRepo.findByAgeLessThan(age);
	}
	
	@GetMapping(value = "/ten/{age}")
	public List<User> findByLessThanEqual(@PathVariable(name = "age") int age) {
		log.info("Performing operation ten : age " + age );
		return userRepo.findByAgeLessThanEqual(age);
	}
	
	@GetMapping(value = "/eleven/{age}")
	public List<User> findByGreaterThan(@PathVariable(name = "age") int age) {
		log.info("Performing operation eleven : age " + age );
		return userRepo.findByAgeGreaterThan(age);
	}
	
	@GetMapping(value = "/twelve/{age}")
	public Page<User> findByGreaterThanEqual(@PathVariable(name = "age") int age) {
		log.info("Performing operation ten : age " + age );
		Pageable page = PageRequest.of(0, 5, Sort.by("id").ascending());
		return userRepo.findByAgeGreaterThanEqual(age, page);
	}
	
	@GetMapping(value = "/thirteen")
	public List<User> findByAfter(@RequestBody User user) {
		log.info("Performing operation thirteen " + user );
		return userRepo.findByStartDateAfter(user.getStartDate());
	}
	
	@GetMapping(value = "/fourteen")
	public List<User> findByBefore(@RequestBody User user) {
		log.info("Performing operation fourteen " + user );
		return userRepo.findByStartDateBefore(user.getStartDate());
	}
	
	@GetMapping(value = "/fifteen")
	public List<User> findByAfterAndGreaterThanEqual(@RequestBody User user) {
		log.info("Performing operation fifteen " + user );
		return userRepo.findByStartDateAfterAndAgeGreaterThanEqual(user.getStartDate(), user.getAge());
	}
	
	/*
	 * @GetMapping(value = "/query/{name}") public User
	 * findByQuery(@PathVariable(name = "name") String name) {
	 * log.info("Performing operation query " + name ); return
	 * userRepo.findByQuery(name); }
	 */
	
}
