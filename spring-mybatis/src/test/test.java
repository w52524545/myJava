package test;  
  
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.UserDaoImpl;  
  
public class test {  
    @SuppressWarnings("resource")
	public static void main(String[] args) {  
        ApplicationContext ctx=null;  
        ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        
        UserDaoImpl userDaoImpl = (UserDaoImpl)ctx.getBean("UserDaoImpl");
//        Map map = new HashMap<>();
//        map.put("id", 11234);
//        map.put("username", "saf");
//        map.put("password", "314");
//        userDaoImpl.insertUser(map);
        
        System.out.println(userDaoImpl.show());
    }  
} 