package com.qc.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.qc.interceptor.QcControllerIntercepter;

public class HelloController extends Controller {
	public void index() {
		renderText("Hello JFinal World.");
	}

	@Before(QcControllerIntercepter.class)
	public void show() {
		String name = getPara("name");
		renderText("this is show method.name : " + name);
	}

	@ActionKey("/login")
	public void login() {
		renderText("login");
	}
}
