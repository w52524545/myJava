package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.manage;
import user.user;
import zhujie.restart;

public class test {
	public static void main(String[] args) {
		String xmlPath = "applicationContext.xml";//�����ļ���ַ
		ClassPathXmlApplicationContext ac= new ClassPathXmlApplicationContext(xmlPath);//��ȡ�����ļ� 
//	    user u = (user) ac.getBean("user");//��ȡ���õ�bean
//	    u.Ashow();//ִ�з���
		
		manage m = (manage) ac.getBean("manage");
		m.Bshow();
		
		restart re = (restart) ac.getBean("RE");
		re.doIt();
    }
}
