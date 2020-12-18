package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Users;
import com.cg.exception.UserIdNotFoundException;
import com.cg.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("user")
	public ResponseEntity<Users> createUser(@Valid @RequestBody Users user)  {
		Users users = userService.createUser(user);
		ResponseEntity<Users> re = new ResponseEntity<Users>(users, HttpStatus.OK);
		return re;
	}

	@GetMapping("user")
	public ResponseEntity<List<Users>> findAllUser()  {

		List<Users> list = userService.listAllUsers();
		ResponseEntity<List<Users>> rt = new ResponseEntity<List<Users>>(list, HttpStatus.OK);
		return rt;

	}

	@DeleteMapping("user/{userId}")
	public ResponseEntity<Users> deleteUserById(@PathVariable("userId") int userId)  {

		ResponseEntity<Users> rt = null;

		try {
			Users user = userService.deleteUser(userId);
			rt = new ResponseEntity<Users>(user, HttpStatus.OK);
		} catch (UserIdNotFoundException e) {
			return new ResponseEntity("User ID" + userId + "NOT FOUND", HttpStatus.BAD_REQUEST);
		}
		return rt;
	}

	@PutMapping("user/{userId}")
	public ResponseEntity<Users> updateUser(@PathVariable("userId") int userId, @Valid @RequestBody Users user)
			

	{
		ResponseEntity<Users> re;
		user.setUserName(user.getUserName());
		user.setEmail(user.getEmail());
		user.setPassword(user.getPassword());
		try {
			Users users = userService.editUser(userId, user);
			re = new ResponseEntity<Users>(users, HttpStatus.OK);
		} catch (UserIdNotFoundException e) {
			re = new ResponseEntity("User ID" + userId + "NOT FOUND", HttpStatus.BAD_REQUEST);
		}
		return re;
	}
}
