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
		String classAndMethod = joinPoint.getTarget().getClass().getName()+"类的" + joinPoint.getSignature().getName();
		logger.info("前置通知："+classAndMethod + "方法开始！");
		System.out.println("前置通知："+classAndMethod + "方法开始！");

	}
	
	@AfterReturning("anyMethod()")
	public void myAfterReturningAdvice(JoinPoint joinPoint) {
		String classAndMethod = joinPoint.getTarget().getClass().getName()+"类的" + joinPoint.getSignature().getName();
		logger.info("后置通知："+classAndMethod + "方法执行正常结束！");
		System.out.println("后置通知："+classAndMethod + "方法执行正常结束！");

	}
	
//	@AfterThrowing("anyMethod()")
//	public void myAfterThrowingAdvice(JoinPoint joinPoint) {
//		String classAndMethod = joinPoint.getTarget().getClass().getName()+"类的" + joinPoint.getSignature().getName();
//		logger.info("异常通知："+classAndMethod + "方法抛出异常！" + );
//	}
//	
	@After("anyMethod()")
	public void myAfterAdvice(JoinPoint joinPoint) {
		String classAndMethod = joinPoint.getTarget().getClass().getName()+"类的" + joinPoint.getSignature().getName();
		logger.info("最终通知："+classAndMethod + "方法执行正常结束！");
		System.out.println("最终通知："+classAndMethod + "方法执行正常结束！");

	}
	
	@Around("anyMethod()")
	public Object myAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		String classAndMethod = joinPoint.getTarget().getClass().getName()+"类的" + joinPoint.getSignature().getName();
		long begintime = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		long endtime = System.currentTimeMillis();
		logger.info("环绕通知："+classAndMethod + "方法执行正常结束！耗时：" + (endtime - begintime)  + "毫秒!");
		System.out.println("环绕通知："+classAndMethod + "方法执行正常结束！耗时：" + (endtime - begintime)  + "毫秒!");
		return result;
	}
}
