package aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ServiceProxy implements InvocationHandler {
	private Object target;

	public ServiceProxy(Object target) {
		this.target = target;
	}

	public Object invoke(Object arg0, Method method, Object[] args) throws Throwable {
		System.out.println("------------------before------------------");
		Object result = method.invoke(target, args);
		System.out.println("-------------------after------------------");
		return result;
	}
}
