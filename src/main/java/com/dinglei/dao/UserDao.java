package com.dinglei.dao;

import com.dinglei.model.User;

public interface UserDao {
	/**
     * @param userId
     * @return User
     */
    public User selectUserById(Integer userId);
}
