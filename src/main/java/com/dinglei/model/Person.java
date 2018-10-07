package com.dinglei.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Person implements BeanFactoryAware, BeanNameAware,  
InitializingBean, DisposableBean {  

	private String name;  
	private String address;  
	private String phone;
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		System.out.println("��ע�����ԡ�ע������phone");  
		this.phone = phone;
	}

	private BeanFactory beanFactory;  
	private String beanName;  
	
	public Person() {  
		System.out.println("��������������Person�Ĺ�����ʵ����");  
	}  
	
	public String getName() {  
		return name;  
	}  
	
	public void setName(String name) {  
		System.out.println("��ע�����ԡ�ע������name");  
		this.name = name;  
	}  
	
	public String getAddress() {  
		return address;  
	}  
	
	public void setAddress(String address) {  
		System.out.println("��ע�����ԡ�ע������address");  
		this.address = address;  
	}  
	
	@Override  
	public String toString() {  
		return "Person [address=" + address + ", name=" + name + "]";  
	}  
	
	// ����BeanFactoryAware�ӿڷ���  
	@Override  
	public void setBeanFactory(BeanFactory arg) throws BeansException {  
		System.out.println("��BeanFactoryAware�ӿڡ�����BeanFactoryAware.setBeanFactory()");  
		this.beanFactory = arg;  
	}  
	
	// ����BeanNameAware�ӿڷ���  
	@Override  
	public void setBeanName(String arg) {  
		System.out.println("��BeanNameAware�ӿڡ�����BeanNameAware.setBeanName()");  
		this.beanName = arg;  
	}  
	
	// ����InitializingBean�ӿڷ���  
	@Override  
	public void afterPropertiesSet() throws Exception {  
		System.out.println("��InitializingBean�ӿڡ�����InitializingBean.afterPropertiesSet()");  
	}  
	
	// ����DiposibleBean�ӿڷ���  
	@Override  
	public void destroy() throws Exception {  
		System.out.println("��DiposibleBean�ӿڡ�����DiposibleBean.destory()");  
	}  
	
	// ͨ��<bean>��init-method����ָ���ĳ�ʼ������  
	public void myInit() throws Exception {
		System.out.println("��init-method������<bean>��init-method����ָ���ĳ�ʼ������");  
	}  
	
	// ͨ��<bean>��destroy-method����ָ���ĳ�ʼ������  
	public void myDestory() throws Exception { 
		System.out.println("��destroy-method������<bean>��destroy-method����ָ���ĳ�ʼ������");  
	}  
}  