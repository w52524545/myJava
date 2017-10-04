package ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoC {
	User user2 = new User();

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("ioc/spring.xml");
		User user = (User) ac.getBean("user");
		user.tellName();
	}
}
