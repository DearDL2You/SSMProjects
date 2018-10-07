package com.dinglei.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	public MyBeanPostProcessor() {  
        super();  
        System.out.println("这是BeanPostProcessor实现类【MyBeanPostProcessor】的构造器！！");           
	}  
	
	
	@Override  
    public Object postProcessAfterInitialization(Object bean, String name)  
            throws BeansException {  
        System.out.println("BeanPostProcessor实现类【MyBeanPostProcessor】的postProcessAfterInitialization对属性进行更改！");  
        return bean;  
    }  
	  
    @Override  
    public Object postProcessBeforeInitialization(Object bean, String name)  
            throws BeansException {  
        System.out.println("BeanPostProcessor实现类【MyBeanPostProcessor】的postProcessBeforeInitialization对属性进行更改！");  
        return bean;  
    }  



}
