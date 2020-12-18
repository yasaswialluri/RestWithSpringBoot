package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.UserDao;
import com.cg.entity.Users;
import com.cg.exception.UserIdNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public Users createUser(Users user) {
		Users users = userDao.saveAndFlush(user);
		return users;
	}

	@Override
	public Users deleteUser(int userId) throws UserIdNotFoundException {
		Users user = null;

		if (userDao.existsById(userId)) {
			user = userDao.findById(userId).get();
			userDao.deleteById(userId);
		} else {
			throw new UserIdNotFoundException("User ID " + userId + " NOT FOUND ");
		}
		return user;
	}

	@Override
	public List<Users> listAllUsers() {
		List<Users> list = userDao.findAll();
		return list;
	}

	@Override
	public Users editUser(int userId, Users user) throws UserIdNotFoundException {

		Users users = null;
		if (userDao.existsById(userId)) {
			users = userDao.saveAndFlush(user);
		} else {
			throw new UserIdNotFoundException("User ID " + userId + " NOT FOUND ");
		}
		return users;
	}

}
