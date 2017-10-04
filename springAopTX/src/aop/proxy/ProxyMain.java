package aop.proxy;

import java.lang.reflect.Proxy;

import aop.proxy.ServiceProxy;
import aop.service.Service;
import aop.service.ServiceImpl;

public class ProxyMain {
	public static void main(String[] args) {
		Service u = new ServiceImpl();
		ServiceProxy handler = new ServiceProxy(u);// 传入被代理的目标对象

		// Proxy.newProxyInstance()返回增强后的代理对象
		Service userProxy = (Service) Proxy.newProxyInstance(u.getClass().getClassLoader(), // 被代理对象的类加载器
				u.getClass().getInterfaces(), // 被代理对象的所有接口的Class对象
				handler);
		userProxy.add();
	}
}
