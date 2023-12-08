package com.example.demo.chapter03.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SampleAspect {
	@Around("execution(* com.example.demo.chapter03.used.Greet.*(..))")
	public Object afterAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("===Around Advice===");
		System.out.println("▼▼▼処理前▼▼▼");
		Object result = joinPoint.proceed();
		System.out.println("▲▲▲処理後▲▲▲");
		
		return result;
	}
}
