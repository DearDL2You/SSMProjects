package com.dinglei.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
 
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
 

@Aspect
public class LogAspect {
    private Map<Long, Map<String, List<Long>>> threadMap = new ConcurrentHashMap<Long, Map<String, List<Long>>>(200);
 
    @Pointcut(value = "execution(* com.dinglei.controller..*.*(..))")
    public void controller() {
    }
 
    @Pointcut(value = "execution(* com.dinglei.dao..*.*(..))")
    public void dao() {
    }
 
    @Pointcut(value = "execution(* com.dinglei.service..*.*(..))")
    public void service() {
    }
 
    @Before(value = "service()")
    public void before(JoinPoint joinPoint) {
        System.out.println(joinPoint.toShortString() + " 开始service");
        Map<String, List<Long>> methodTimeMap = threadMap.get(Thread.currentThread().getId());
        List<Long> list;
        if (methodTimeMap == null) {
            methodTimeMap = new HashMap<String, List<Long>>();
            list = new LinkedList<Long>();
            list.add(System.currentTimeMillis());
            methodTimeMap.put(joinPoint.toShortString(), list);
            threadMap.put(Thread.currentThread().getId(), methodTimeMap);
        } else {
            list = methodTimeMap.get(joinPoint.toShortString());
            if (list == null) list = new LinkedList<Long>();
            list.add(System.currentTimeMillis());
            methodTimeMap.put(joinPoint.toShortString(), list);
        }
    }
    
    @Before(value = "controller()")
    public void beforeController(JoinPoint joinPoint) {
        System.out.println(joinPoint.toShortString() + " 开始beforeController");
        Map<String, List<Long>> methodTimeMap = threadMap.get(Thread.currentThread().getId());
        List<Long> list;
        if (methodTimeMap == null) {
            methodTimeMap = new HashMap<String, List<Long>>();
            list = new LinkedList<Long>();
            list.add(System.currentTimeMillis());
            methodTimeMap.put(joinPoint.toShortString(), list);
            threadMap.put(Thread.currentThread().getId(), methodTimeMap);
        } else {
            list = methodTimeMap.get(joinPoint.toShortString());
            if (list == null) list = new LinkedList<Long>();
            list.add(System.currentTimeMillis());
            methodTimeMap.put(joinPoint.toShortString(), list);
        }
    }
    
    @Before(value = "dao()")
    public void beforeDao(JoinPoint joinPoint) {
        System.out.println(joinPoint.toShortString() + " 开始dao");
        Map<String, List<Long>> methodTimeMap = threadMap.get(Thread.currentThread().getId());
        List<Long> list;
        if (methodTimeMap == null) {
            methodTimeMap = new HashMap<String, List<Long>>();
            list = new LinkedList<Long>();
            list.add(System.currentTimeMillis());
            methodTimeMap.put(joinPoint.toShortString(), list);
            threadMap.put(Thread.currentThread().getId(), methodTimeMap);
        } else {
            list = methodTimeMap.get(joinPoint.toShortString());
            if (list == null) list = new LinkedList<Long>();
            list.add(System.currentTimeMillis());
            methodTimeMap.put(joinPoint.toShortString(), list);
        }
    }
 
    @After(value = "controller() || dao() || service()")
    public void after(JoinPoint joinPoint) {
        System.out.println(joinPoint.toShortString() + " 结束");
        Map<String, List<Long>> methodTimeMap = threadMap.get(Thread.currentThread().getId());
        List<Long> list = methodTimeMap.get(joinPoint.toShortString());
        System.out.println("耗时：" +
                (System.currentTimeMillis() - list.get(list.size() - 1)));
        list.remove(list.size() - 1);
    }
}
