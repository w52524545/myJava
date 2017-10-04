package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 第二个servlet
 * 
 * 目的 1.获取浏览器地址栏传来的参数
 * 
 * 2.响应在浏览器
 */
public class MySecondServlet extends HttpServlet {
	/*
	 * 覆盖父类(HttpServlet)类的service方法
	 * 
	 * 当请求这个servlet的时候, 实际是请求这个servlet的service方法
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) //
			throws ServletException, IOException {
		// 获取从浏览器地址栏传来的参数
		String name = request.getParameter("name");

		// PrintWriter对象可以向前台输出数据
		PrintWriter writer = response.getWriter();

		// 通过PrintWriter的writer方法 向前台输出文字
		writer.write("my name is:" + name);
	}
}
