package com.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 这是第一个servlet
 *
 * 目的是了解servlet是如何配置在web.xml中,在浏览器如何访问到
 */
public class MyFirstServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) //
			throws javax.servlet.ServletException, java.io.IOException {
		System.out.println("MyFirstServlet执行了");
	}
}
