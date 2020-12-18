package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_table")
public class Users {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mygen")
	@SequenceGenerator(name = "mygen", sequenceName = "user_sequence", allocationSize = 1)
	private int userId;
	@NotNull(message = "Name cannot be null")
	@Size(min = 8, max = 30, message = "Name should be between 8 and 30 characters")
	@Column(name = "user_name", length = 20)

	private String userName;
	@NotNull(message = "Email cannot be null")
	@Size(min = 10, max = 64, message = "email should be between 10 to 64 characters")
	@Column(name = "email", length = 30)
	@Email
	private String email;
	@NotNull(message = "password cannot be null")
	@Size(min = 8, max = 16, message = "password should be between 8 to 16  characters")
	@Column(name = "password", length = 20)
	private String password;

	public Users(int userId,
			@NotNull(message = "Name cannot be null") @Size(min = 8, max = 30, message = "Name should be between 8 and 30 characters") String userName,
			@NotNull(message = "Email cannot be null") @Size(min = 10, max = 64, message = "email should be between 10 to 64 characters") @Email String email,
			@NotNull(message = "password cannot be null") @Size(min = 8, max = 16, message = "password should be between 8 to 16  characters") String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}
	
	

	public Users() {
		super();
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
