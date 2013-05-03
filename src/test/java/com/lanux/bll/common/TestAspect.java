package com.lanux.bll.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;

public class TestAspect {

	public void pointCut() {
	}

	public void afterReturning(JoinPoint jp, Object obj) {
		System.out.println("返回之后: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName() + "  返回：" + obj);
	}

	public void doBefore(JoinPoint jp) {
		System.out.println("开始之前: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
	}

	public void doAfter(JoinPoint jp) {
		System.out.println("结束之后: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
	}

	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		long time = System.currentTimeMillis();
		Object retVal = pjp.proceed();
		time = System.currentTimeMillis() - time;
		System.out.println("处理时间: " + time + " ms");
		return retVal;
	}

	@AfterThrowing("pointCut()")
	public void doThrowing(JoinPoint jp) {
		System.out.println("抛出异常: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName() + " throw exception");
	}
}
