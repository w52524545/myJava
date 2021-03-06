package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import dao.consumerDao;
import getCode.getCode;

@Controller
public class consumerController {
	private ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringConf.xml");
	private consumerDao consumer = (consumerDao) ctx.getBean("consumerDaoImpl");

	@RequestMapping(value = "/getCheckCode", method = RequestMethod.GET)
	public void getCheckCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String consumerPhone = request.getParameter("consumerPhone");
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> map2 = new HashMap<>();
		map = consumer.findconsumerPhone(consumerPhone);
		String json = null;
		String checkCode = "0";
		if (map == null) {
			map = consumer.findmanagerPhone(consumerPhone);
			if (map == null) {
				map2.put(consumerPhone, checkCode);
				session.setAttribute("map", map2);
				json = JSON.toJSONString(map2);
			} else {
				checkCode = getCode.code();
				map.put(consumerPhone, checkCode);
				session.setAttribute("map", map);
				json = JSON.toJSONString(map);
			}
		} else {
			checkCode = getCode.code();
			map.put(consumerPhone, checkCode);
			session.setAttribute("map", map);
			json = JSON.toJSONString(map);
		}
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(json);
	}

	@RequestMapping(value = "/loginok", method = RequestMethod.GET)
	public ModelAndView getConsumer(HttpServletRequest request) throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		String consumerPhone = request.getParameter("consumerPhone");
		System.out.println(consumerPhone);
		Map<String, Object> map = new HashMap<>();
		map = consumer.findconsumerPhone(consumerPhone);
		if (map == null) {
			map = consumer.findmanagerPhone(consumerPhone);
			mv.addObject("map", map);
			mv.setViewName("/welcomeM.jsp");
		} else {
			mv.addObject("map", map);
			mv.setViewName("/welcome.jsp");
		}
		return mv;
	}

	@RequestMapping(value = "/getBalance", method = RequestMethod.POST)
	public void getbalance(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String consumerPhone = request.getParameter("consumerPhone");
		String cost = request.getParameter("cost");

		Map<String, Object> map1 = new HashMap<>();
		Map<String, Object> map2 = new HashMap<>();

		map2.put("consumerPhone", consumerPhone);
		map2.put("cost", cost);

		map1.put("consumerPhone", consumerPhone);
		map1.put("cost", cost);
		map1.put("inOrOut", "i");
		Integer balance = (Integer) consumer.findconsumerPhone(consumerPhone).get("balance");
		map1.put("balance", balance);

		consumer.addBalance(map2, map1);

		System.out.println(map1);
		String json = JSON.toJSONString(map1);
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(json);
	}

	@RequestMapping(value = "/getAllSys", method = RequestMethod.POST)
	public void getSys(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Map<String, Object>> list = consumer.selectAllSys();
		request.setAttribute("list", list);
		String json = JSON.toJSONString(list);
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(json);
	}

	@RequestMapping(value = "/getSerSys", method = RequestMethod.POST)
	public void getser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Map<String, Object>> list = consumer.selectser();
		request.setAttribute("list", list);
		String json = JSON.toJSONString(list);
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(json);
	}

	@RequestMapping(value = "/getcou", method = RequestMethod.POST)
	public void getcou(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Map<String, Object>> list = consumer.selectcon();
		request.setAttribute("list", list);
		String json = JSON.toJSONString(list);
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(json);
	}

	@RequestMapping(value = "/AddSys", method = RequestMethod.GET)
	public void AddSys(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String idcard = request.getParameter("idcard");
		String role = request.getParameter("role");
		String pwd = request.getParameter("pwd");
		String shopName = request.getParameter("shopName");
		String shopPhone = request.getParameter("shopPhone");

		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("phone", phone);
		map.put("idcard", idcard);
		map.put("role", role);
		map.put("pwd", pwd);
		map.put("shopName", shopName);
		map.put("shopPhone", shopPhone);

		consumer.AddSys(map);
		String json = JSON.toJSONString(1);
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(json);
	}

	@RequestMapping(value = "/AddCou", method = RequestMethod.GET)
	public void AddCou(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String consumerPhone = request.getParameter("consumerPhone");
		String shopPhone = request.getParameter("shopPhone");
		String serverPhone = request.getParameter("serverPhone");
		String balance = request.getParameter("balance");

		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("consumerPhone", consumerPhone);
		map.put("shopPhone", shopPhone);
		map.put("serverPhone", serverPhone);
		map.put("balance", balance);

		consumer.AddCou(map);
		String json = JSON.toJSONString(1);
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(json);
	}

	@RequestMapping(value = "/deleteSys", method = RequestMethod.GET)
	public void delSys(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String rn = request.getParameter("rn");
		System.out.println(rn);
		consumer.deleteSys(rn);
		String json = JSON.toJSONString(1);
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(json);
	}

	@RequestMapping(value = "/deleteCou", method = RequestMethod.GET)
	public void delCou(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String rn = request.getParameter("rn");
		System.out.println(rn);
		consumer.deleteCou(rn);
		String json = JSON.toJSONString(1);
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(json);
	}
}
