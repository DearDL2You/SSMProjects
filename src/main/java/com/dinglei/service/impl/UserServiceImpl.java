package com.dinglei.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinglei.dao.UserDao;
import com.dinglei.model.User;
import com.dinglei.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public User selectUserById(Integer userId) {
        return userDao.selectUserById(userId);  
	}

}
