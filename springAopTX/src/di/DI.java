package di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DI {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("ioc/spring.xml");
		Boss boss = null;
		boss = (Boss) ac.getBean("boss2");
		boss._do();

	}

}
