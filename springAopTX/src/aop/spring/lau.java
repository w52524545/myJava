package aop.spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class lau implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("---------start");
		Object obj = arg0.proceed();
		System.out.println("stop----------");
		return obj;
	}

}
