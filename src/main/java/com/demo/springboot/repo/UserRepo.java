package com.demo.springboot.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.springboot.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	/*
	 * @Query(value = "SELECT u FROM user u WHERE u.firstname = ?1") User
	 * findByQuery(String name);
	 */

	User findByFirstname(String firstname);

	User findByFirstnameAndLastname(String firstname, String lastname);

	User findByAgeAndActiveAndStartDate(int age, boolean active, Date date);

	List<User> findByAgeOrActiveOrFirstname(int age, boolean active, String firstname);

	List<User> findByAgeOrActiveAndFirstname(int age, boolean active, String firstname);

	List<User> findByAgeOrActiveIs(int age, boolean active);

	List<User> findByAgeOrActiveEquals(int age, boolean active);

	List<User> findByAgeBetween(int startAge, int endAge);

	List<User> findByAgeLessThan(int age);

	List<User> findByAgeLessThanEqual(int age);

	List<User> findByAgeGreaterThan(int age);

	Page<User> findByAgeGreaterThanEqual(int age, Pageable page);
	
	List<User> findByStartDateAfter(Date date);
	
	List<User> findByStartDateBefore(Date date);

	List<User> findByStartDateAfterAndAgeGreaterThanEqual(Date date, int age);


}
