package com.srvcode.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Email(message = "Invalid e-mail")
	@NotEmpty(message = "Can't be empty")
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "password")
	//@Transient
	private String password;
	
	@NotEmpty(message = "Please enter first Name")
	@Column(name = "first_name")
	private String firstName;
	
	@NotEmpty(message = "Please enter last Name")
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@Column(name = "confirmation_token")
	private String confirmationToken;
}
