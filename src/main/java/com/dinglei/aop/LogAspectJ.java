package com.dinglei.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class LogAspectJ {
	public Logger logger = Logger.getLogger(LogAspectJ.class);
    @Pointcut(value = "execution(* com.dinglei..*.*(..))")
	private void anyMethod() {}
	
	@Before("anyMethod()")
	public void myBeforeAdvice(JoinPoint joinPoint) {
		String classAndMethod = joinPoint.getTarget().getClass().getName()+"���" + joinPoint.getSignature().getName();
		logger.info("ǰ��֪ͨ��"+classAndMethod + "������ʼ��");
		System.out.println("ǰ��֪ͨ��"+classAndMethod + "������ʼ��");

	}
	
	@AfterReturning("anyMethod()")
	public void myAfterReturningAdvice(JoinPoint joinPoint) {
		String classAndMethod = joinPoint.getTarget().getClass().getName()+"���" + joinPoint.getSignature().getName();
		logger.info("����֪ͨ��"+classAndMethod + "����ִ������������");
		System.out.println("����֪ͨ��"+classAndMethod + "����ִ������������");

	}
	
//	@AfterThrowing("anyMethod()")
//	public void myAfterThrowingAdvice(JoinPoint joinPoint) {
//		String classAndMethod = joinPoint.getTarget().getClass().getName()+"���" + joinPoint.getSignature().getName();
//		logger.info("�쳣֪ͨ��"+classAndMethod + "�����׳��쳣��" + );
//	}
//	
	@After("anyMethod()")
	public void myAfterAdvice(JoinPoint joinPoint) {
		String classAndMethod = joinPoint.getTarget().getClass().getName()+"���" + joinPoint.getSignature().getName();
		logger.info("����֪ͨ��"+classAndMethod + "����ִ������������");
		System.out.println("����֪ͨ��"+classAndMethod + "����ִ������������");

	}
	
	@Around("anyMethod()")
	public Object myAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		String classAndMethod = joinPoint.getTarget().getClass().getName()+"���" + joinPoint.getSignature().getName();
		long begintime = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		long endtime = System.currentTimeMillis();
		logger.info("����֪ͨ��"+classAndMethod + "����ִ��������������ʱ��" + (endtime - begintime)  + "����!");
		System.out.println("����֪ͨ��"+classAndMethod + "����ִ��������������ʱ��" + (endtime - begintime)  + "����!");
		return result;
	}
}
