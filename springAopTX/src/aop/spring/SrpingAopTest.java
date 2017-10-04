package aop.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop.SSS.R;
import aop.SSS.SSR;
import aop.service.Service;

public class SrpingAopTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("aop/spring/springAop.xml");

		Service service = (Service) ac.getBean("service2");
		service.add();
		System.out.println();
		service.delete();
		System.out.println();
		service.update();
		System.out.println();

		Service service1 = (Service) ac.getBean("service1");
		service1.add();
		System.out.println();
		service1.delete();
		System.out.println();
		service1.update();

		R ssr = (R) ac.getBean("ssr");
		ssr.power();
		System.out.println();
		ssr.blood();
		System.out.println();
		SSR s = (SSR) ssr;
		s.laugh();
		System.out.println();

		R n = (R) ac.getBean("n");
		n.power();
		System.out.println();
		n.blood();
		System.out.println();
	}
}
