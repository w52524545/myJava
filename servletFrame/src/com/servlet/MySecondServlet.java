package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �ڶ���servlet
 * 
 * Ŀ�� 1.��ȡ�������ַ�������Ĳ���
 * 
 * 2.��Ӧ�������
 */
public class MySecondServlet extends HttpServlet {
	/*
	 * ���Ǹ���(HttpServlet)���service����
	 * 
	 * ���������servlet��ʱ��, ʵ�����������servlet��service����
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) //
			throws ServletException, IOException {
		// ��ȡ���������ַ�������Ĳ���
		String name = request.getParameter("name");

		// PrintWriter���������ǰ̨�������
		PrintWriter writer = response.getWriter();

		// ͨ��PrintWriter��writer���� ��ǰ̨�������
		writer.write("my name is:" + name);
	}
}
