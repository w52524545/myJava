package aop;

import java.lang.reflect.Method;

public class MainReflect {

	public static void main(String[] args) {
		try {
			Class<?> cls = Class.forName("aop.service.ServiceImpl");
			Method method = cls.getMethod("add");
			System.out.println("调用方法前,增加xxxx代码");
			method.invoke(cls.newInstance());
			System.out.println("调用方法以后,再增加zzzzzzz代码");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
