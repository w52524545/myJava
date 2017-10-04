package aop.spring;

import java.util.Scanner;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyQieMian implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		Scanner aScanner = new Scanner(System.in);
		int b = aScanner.nextInt();
		System.out.println("-------------"+arg0.getMethod()+"++");
		System.out.print(arg0.getMethod());
		Object obj = arg0.proceed();
		System.out.println();
		return obj;
	}

}
