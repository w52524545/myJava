package com.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ���ǵ�һ��servlet
 *
 * Ŀ�����˽�servlet�����������web.xml��,���������η��ʵ�
 */
public class MyFirstServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) //
			throws javax.servlet.ServletException, java.io.IOException {
		System.out.println("MyFirstServletִ����");
	}
}
