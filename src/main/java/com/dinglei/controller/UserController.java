package com.dinglei.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dinglei.model.User;
import com.dinglei.service.UserService;

@Controller
public class UserController {
	
	@Resource  
    private UserService userService; 

    @RequestMapping("/getIndex")    
    public ModelAndView getIndex(){      
        ModelAndView mav = new ModelAndView("index"); 
        User user = userService.selectUserById(1); 
        mav.addObject("user", user); 
        return mav; 
    }    
}
