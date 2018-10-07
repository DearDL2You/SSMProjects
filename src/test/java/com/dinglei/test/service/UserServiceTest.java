package com.dinglei.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.dinglei.model.User;
import com.dinglei.service.UserService;
import com.dinglei.test.SpringTestCase;

public class UserServiceTest extends SpringTestCase {
	@Autowired  
    private UserService userService; 

    @Test  
    public void selectUserByIdTest(){  
        User user = userService.selectUserById(1);  
        if(user != null) {
        	System.out.println(user.getUserName() + ":" + user.getUserPassword());
        }
        	System.out.println("³É¹¦£¡£¡£¡");
    }
}
