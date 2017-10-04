package aop.spring;

import java.util.Scanner;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//切面 也就是增强的代码
public class MyAspect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		Scanner a = new Scanner(System.in);
		int b = a.nextInt();
		System.out.print("hello World!");// 增强的代码
		Object obj = mi.proceed();
		System.out.println("------How are you?");
		return b * b;
		// return obj;
	}

}
