package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Users;

@Repository
public interface UserDao extends JpaRepository<Users, Integer> {

}
