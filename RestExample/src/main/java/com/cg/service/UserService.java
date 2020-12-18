package com.cg.service;

import java.util.List;

import com.cg.entity.Users;
import com.cg.exception.UserIdNotFoundException;

public interface UserService {

	public Users createUser(Users user);

	public Users deleteUser(int userId) throws UserIdNotFoundException;

	public List<Users> listAllUsers();

	public Users editUser(int userId, Users user) throws UserIdNotFoundException;
}
