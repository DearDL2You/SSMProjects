package com.dinglei.test.initialize;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dinglei.model.Person;

public class BeanInitializeTest {
	 public static void main(String[] args) {  
		   
	        System.out.println("���ڿ�ʼ��ʼ������");  
	          
	        ApplicationContext ctx = new ClassPathXmlApplicationContext("beanContent/beanInitialize.xml");  
	        System.out.println("������ʼ���ɹ�");      
	   
	        //�õ�Preson����ʹ��  
	        Person person = ctx.getBean("person",Person.class);  
	        System.out.println(person);  
	          
	        System.out.println("���ڿ�ʼ�ر�������");  
	        ((ClassPathXmlApplicationContext)ctx).registerShutdownHook();  
	    }  
}
