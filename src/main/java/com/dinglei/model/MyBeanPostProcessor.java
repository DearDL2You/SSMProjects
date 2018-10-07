package com.dinglei.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	public MyBeanPostProcessor() {  
        super();  
        System.out.println("����BeanPostProcessorʵ���ࡾMyBeanPostProcessor���Ĺ���������");           
	}  
	
	
	@Override  
    public Object postProcessAfterInitialization(Object bean, String name)  
            throws BeansException {  
        System.out.println("BeanPostProcessorʵ���ࡾMyBeanPostProcessor����postProcessAfterInitialization�����Խ��и��ģ�");  
        return bean;  
    }  
	  
    @Override  
    public Object postProcessBeforeInitialization(Object bean, String name)  
            throws BeansException {  
        System.out.println("BeanPostProcessorʵ���ࡾMyBeanPostProcessor����postProcessBeforeInitialization�����Խ��и��ģ�");  
        return bean;  
    }  



}
