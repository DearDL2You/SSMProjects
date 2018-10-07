package com.dinglei.test.initialize;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dinglei.model.Person;

public class BeanInitializeTest {
	 public static void main(String[] args) {  
		   
	        System.out.println("现在开始初始化容器");  
	          
	        ApplicationContext ctx = new ClassPathXmlApplicationContext("beanContent/beanInitialize.xml");  
	        System.out.println("容器初始化成功");      
	   
	        //得到Preson，并使用  
	        Person person = ctx.getBean("person",Person.class);  
	        System.out.println(person);  
	          
	        System.out.println("现在开始关闭容器！");  
	        ((ClassPathXmlApplicationContext)ctx).registerShutdownHook();  
	    }  
}
