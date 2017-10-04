package com.controller;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/one")
public class OneController {

	@SuppressWarnings("unused")
	private SqlSessionTemplate sqlSession;
	@RequestMapping(value = "/a")
	public String a() {
		System.out.println("aaaaa");
		return "/b.jsp";
	}

	@RequestMapping(value = "/b")
	public String b() {
		return "/c/c.jsp";
	}
}
