package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import impl.UserDaoImpl;

@Controller
public class UserController {
	private ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringConf.xml");
	private UserDaoImpl user = (UserDaoImpl) ctx.getBean("UserDaoImpl");

	@RequestMapping(value = "/findUser", method = RequestMethod.POST)
	public ModelAndView getUser(HttpServletRequest request,ModelAndView modelAndView) {
		String id = request.getParameter("id");
		System.out.println(id);
		@SuppressWarnings("rawtypes")
		Map map = user.findUserById(id);
		modelAndView.addObject("map", map);
		return modelAndView;
	}

	@RequestMapping("/")
	public String getIndex() {
		return "index";
	}

}