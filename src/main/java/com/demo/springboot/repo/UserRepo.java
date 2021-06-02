package com.demo.springboot.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.springboot.model.LastNameOnly;
import com.demo.springboot.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	@Query(value = "SELECT u FROM User u where u.active = ?1 ORDER BY u.id ASC")
	List<User> findByQuery(Boolean active);

	List<User> findAllOrderedByIdAscending();

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

	List<User> findByStartDateAfter(Date date, Sort sort);

	List<User> findByStartDateBefore(Date date);

	List<User> findByStartDateAfterAndAgeGreaterThanEqual(Date date, int age);

	List<User> findByLastnameContaining(String name);

	List<User> findByLastnameNotLike(String name);

	List<User> findByFirstnameStartingWith(String name);

	List<User> findByFirstnameEndingWith(String name);

	List<User> findByFirstnameIgnoreCase(String name);

	List<User> findByFirstnameIgnoreCaseStartingWith(String name);

	List<User> findByActiveTrue();

	List<User> findByActiveFalse();

	List<User> findByFirstnameNot(String name);

	List<User> findByAgeIn(List<Integer> ages);

	List<User> findByAgeNotIn(List<Integer> ages);

	List<User> findByFirstnameOrderByIdAsc(String name);

	List<User> findByFirstnameLike(String name);

	List<User> findByFirstnameStartsWith(String name);

	List<User> findByFirstnameEndsWith(String name);

	List<User> findTop2ByActiveTrue();

	List<User> findFirst3ByActiveFalse();

	int countByAge(int age);

	List<User> findByLastnameEndsWith(String name);

	List<User> findByAgeIsNull();

	List<User> findByFirstnameIsNot(String name);

	List<User> readByActiveTrue();

	List<User> queryByActiveTrue();

	List<User> getByActiveFalse();
	
	List<LastNameOnly> findDistinctAllByLastname(String name);


}
