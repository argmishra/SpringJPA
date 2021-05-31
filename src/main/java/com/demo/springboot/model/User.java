package com.demo.springboot.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@Getter @Setter @AllArgsConstructor @ToString @NoArgsConstructor
@NamedQuery(name = "User.findAllByAgeOrderedByIdDescending",query = "SELECT u FROM User u where u.age > :age ORDER BY u.id DESC")
@NamedQuery(name = "User.findAllOrderedByIdAscending",query = "SELECT u FROM User u ORDER BY u.id ASC")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "first_name")
	private String firstname;
	
	@Column(name = "last_name")
	private String lastname;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "active")
	private boolean active;

}
