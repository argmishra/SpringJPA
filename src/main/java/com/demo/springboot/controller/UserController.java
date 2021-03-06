package com.demo.springboot.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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

import com.demo.springboot.model.LastNameOnly;
import com.demo.springboot.model.User;
import com.demo.springboot.repo.UserRepo;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("users")
@Log4j2
public class UserController {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private EntityManager entityManager;

	@GetMapping(value = "/parameternamedquery/{age}")
	public List<User> findByNamedQueryWithParameter(@PathVariable(name = "age") int age) {
		log.info("Performing operation named query with parameter " + age);
		Query query = entityManager.createNamedQuery("User.findAllByAgeOrderedByIdDescending");
		query.setParameter("age", age);
		return query.getResultList();
	}

	@GetMapping(value = "/query/{active}")
	public List<User> findByQuery(@PathVariable(name = "active") Boolean active) {
		log.info("Performing operation query " + active);
		return userRepo.findByQuery(active);
	}

	@GetMapping(value = "/namedquery")
	public List<User> findByNamedQueryWithoutParameter() {
		log.info("Performing operation named query with out parameter");
		return userRepo.findAllOrderedByIdAscending();
	}

	@GetMapping(value = "/one")
	public User findByParameter(@RequestBody User user) {
		log.info("Performing operation one " + user);
		return userRepo.findByFirstname(user.getFirstname());
	}

	@GetMapping(value = "/two")
	public User findByTwoParametersWithAnd(@RequestBody User user) {
		log.info("Performing operation two " + user);
		return userRepo.findByFirstnameAndLastname(user.getFirstname(), user.getLastname());
	}

	@GetMapping(value = "/three")
	public User findByMultipleParametersWithAnd(@RequestBody User user) {
		log.info("Performing operation three " + user);
		return userRepo.findByAgeAndActiveAndStartDate(user.getAge(), user.getActive(), user.getStartDate());
	}

	@GetMapping(value = "/four")
	public List<User> findByMultipleParametersWithOr(@RequestBody User user) {
		log.info("Performing operation four " + user);
		return userRepo.findByAgeOrActiveOrFirstname(user.getAge(), user.getActive(), user.getFirstname());
	}

	@GetMapping(value = "/five")
	public List<User> findByMultipleParametersWithAndOr(@RequestBody User user) {
		log.info("Performing operation five " + user);
		return userRepo.findByAgeOrActiveAndFirstname(user.getAge(), user.getActive(), user.getFirstname());
	}

	@GetMapping(value = "/six")
	public List<User> findByMultipleParametersIs(@RequestBody User user) {
		log.info("Performing operation six " + user);
		return userRepo.findByAgeOrActiveIs(user.getAge(), user.getActive());
	}

	@GetMapping(value = "/seven")
	public List<User> findByMultipleParametersEquals(@RequestBody User user) {
		log.info("Performing operation seven " + user);
		return userRepo.findByAgeOrActiveEquals(user.getAge(), user.getActive());
	}

	@GetMapping(value = "/eight")
	public List<User> findByBetween(@RequestParam(name = "start") int startAge,
			@RequestParam(name = "end") int endAge) {
		log.info("Performing operation eight : start date " + startAge + " and end date " + endAge);
		return userRepo.findByAgeBetween(startAge, endAge);
	}

	@GetMapping(value = "/nine/{age}")
	public List<User> findByLessThan(@PathVariable(name = "age") int age) {
		log.info("Performing operation nine : age " + age);
		return userRepo.findByAgeLessThan(age);
	}

	@GetMapping(value = "/ten/{age}")
	public List<User> findByLessThanEqual(@PathVariable(name = "age") int age) {
		log.info("Performing operation ten : age " + age);
		return userRepo.findByAgeLessThanEqual(age);
	}

	@GetMapping(value = "/eleven/{age}")
	public List<User> findByGreaterThan(@PathVariable(name = "age") int age) {
		log.info("Performing operation eleven : age " + age);
		return userRepo.findByAgeGreaterThan(age);
	}

	@GetMapping(value = "/twelve/{age}")
	public Page<User> findByGreaterThanEqual(@PathVariable(name = "age") int age) {
		log.info("Performing operation ten : age " + age);
		Pageable page = PageRequest.of(0, 5, Sort.by("id").ascending());
		return userRepo.findByAgeGreaterThanEqual(age, page);
	}

	@GetMapping(value = "/thirteen")
	public List<User> findByAfter(@RequestBody User user) {
		log.info("Performing operation thirteen " + user);
		return userRepo.findByStartDateAfter(user.getStartDate(), Sort.by("age").ascending());
	}

	@GetMapping(value = "/fourteen")
	public List<User> findByBefore(@RequestBody User user) {
		log.info("Performing operation fourteen " + user);
		return userRepo.findByStartDateBefore(user.getStartDate());
	}

	@GetMapping(value = "/fifteen")
	public List<User> findByAfterAndGreaterThanEqual(@RequestBody User user) {
		log.info("Performing operation fifteen " + user);
		return userRepo.findByStartDateAfterAndAgeGreaterThanEqual(user.getStartDate(), user.getAge());
	}

	@GetMapping(value = "/sixteen/{name}")
	public List<User> findByContaining(@PathVariable(name = "name") String name) {
		log.info("Performing operation sixteen : name " + name);
		return userRepo.findByLastnameContaining(name);
	}

	@GetMapping(value = "/seventeen/{name}")
	public List<User> findByNotLike(@PathVariable(name = "name") String name) {
		log.info("Performing operation seventeen : name " + name);
		return userRepo.findByLastnameNotLike(name);
	}

	@GetMapping(value = "/eighteen/{name}")
	public List<User> findByStartingWith(@PathVariable(name = "name") String name) {
		log.info("Performing operation eighteen : name " + name);
		return userRepo.findByFirstnameStartingWith(name);
	}

	@GetMapping(value = "/nineteen/{name}")
	public List<User> findByEndingWith(@PathVariable(name = "name") String name) {
		log.info("Performing operation nineteen : name " + name);
		return userRepo.findByFirstnameEndingWith(name);
	}

	@GetMapping(value = "/twenty/{name}")
	public List<User> findByIgnoreCase(@PathVariable(name = "name") String name) {
		log.info("Performing operation twenty : name " + name);
		return userRepo.findByFirstnameIgnoreCase(name);
	}

	@GetMapping(value = "/twentyone/{name}")
	public List<User> findByIgnoreCaseAndStartingWith(@PathVariable(name = "name") String name) {
		log.info("Performing operation twentyone : name " + name);
		return userRepo.findByFirstnameIgnoreCaseStartingWith(name);
	}

	@GetMapping(value = "/twentytwo")
	public List<User> findByTrue() {
		log.info("Performing operation twentytwo");
		return userRepo.findByActiveTrue();
	}

	@GetMapping(value = "/twentythree")
	public List<User> findByFalse() {
		log.info("Performing operation twentyThree");
		return userRepo.findByActiveFalse();
	}

	@GetMapping(value = "/twentyfour/{name}")
	public List<User> findByNot(@PathVariable(name = "name") String name) {
		log.info("Performing operation twentyfour : name " + name);
		return userRepo.findByFirstnameNot(name);
	}

	@GetMapping(value = "/twentyfive")
	public List<User> findByIn(@RequestBody List<Integer> ages) {
		log.info("Performing operation twentyfive : ages " + ages);
		return userRepo.findByAgeIn(ages);
	}

	@GetMapping(value = "/twentysix")
	public List<User> findByNot(@RequestBody List<Integer> ages) {
		log.info("Performing operation twentysix : ages " + ages);
		return userRepo.findByAgeNotIn(ages);
	}

	@GetMapping(value = "/twentyseven/{name}")
	public List<User> findOrderBy(@PathVariable(name = "name") String name) {
		log.info("Performing operation twentyseven : name " + name);
		return userRepo.findByFirstnameOrderByIdAsc(name);
	}

	@GetMapping(value = "/twentyeight/{name}")
	public List<User> findByLike(@PathVariable(name = "name") String name) {
		log.info("Performing operation twentyeight : name " + name);
		return userRepo.findByFirstnameLike(name);
	}

	@GetMapping(value = "/twentynine/{name}")
	public List<User> findByStartsWith(@PathVariable(name = "name") String name) {
		log.info("Performing operation twentynine : name " + name);
		return userRepo.findByFirstnameStartsWith(name);
	}

	@GetMapping(value = "/thirty/{name}")
	public List<User> findByEndsWith(@PathVariable(name = "name") String name) {
		log.info("Performing operation thirty : name " + name);
		return userRepo.findByFirstnameEndsWith(name);
	}

	@GetMapping(value = "/thirtyone")
	public List<User> findByTop() {
		log.info("Performing operation thirtyone");
		return userRepo.findTop2ByActiveTrue();
	}

	@GetMapping(value = "/thirtytwo")
	public List<User> findByFirst() {
		log.info("Performing operation thirtytwo");
		return userRepo.findFirst3ByActiveFalse();
	}

	@GetMapping(value = "/thirtythree/{name}")
	public List<LastNameOnly> findByDistinct(@PathVariable(name = "name") String name) {
	log.info("Performing operation thirtythree : name " + name);
	 return userRepo.findDistinctAllByLastname(name);
	}

	@GetMapping(value = "/thirtyfour/{age}")
	public int count(@PathVariable(name = "age") int age) {
		log.info("Performing operation thirtythree : age " + age);
		return userRepo.countByAge(age);
	}

	@GetMapping(value = "/thirtyfive")
	public List<User> findBy() {
		log.info("Performing operation thirtyfive");
		return userRepo.findByActiveTrue();
	}

	@GetMapping(value = "/thirtysix")
	public List<User> readBy() {
		log.info("Performing operation thirtysix");
		return userRepo.readByActiveTrue();
	}

	@GetMapping(value = "/thirtyseven")
	public List<User> queryBy() {
		log.info("Performing operation thirtyseven");
		return userRepo.queryByActiveTrue();
	}

	@GetMapping(value = "/thirtyeight")
	public List<User> getBy() {
		log.info("Performing operation thirtyeight");
		return userRepo.getByActiveFalse();
	}

	@GetMapping(value = "/thirtynine")
	public List<User> getNull() {
		log.info("Performing operation thirtynine");
		return userRepo.findByAgeIsNull();
	}

	@GetMapping(value = "/fourty/{name}")
	public List<User> findisNot(@PathVariable(name = "name") String name) {
		log.info("Performing operation fourty : name " + name);
		return userRepo.findByFirstnameIsNot(name);
	}

}
