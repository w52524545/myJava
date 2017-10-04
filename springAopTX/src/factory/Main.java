package factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = //
				new ClassPathXmlApplicationContext("factory/spring.xml");
		
		User user = (User)ac.getBean("user");
		user.show();
	}
}
