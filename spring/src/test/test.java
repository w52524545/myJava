package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.manage;
import user.user;
import zhujie.restart;

public class test {
	public static void main(String[] args) {
		String xmlPath = "applicationContext.xml";//配置文件地址
		ClassPathXmlApplicationContext ac= new ClassPathXmlApplicationContext(xmlPath);//获取配置文件 
//	    user u = (user) ac.getBean("user");//获取配置的bean
//	    u.Ashow();//执行方法
		
		manage m = (manage) ac.getBean("manage");
		m.Bshow();
		
		restart re = (restart) ac.getBean("RE");
		re.doIt();
    }
}
