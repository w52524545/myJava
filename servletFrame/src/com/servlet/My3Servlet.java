package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Ŀ����:����������html.css,js
 * 
 * ����Ϊ�Ժ��jsp���̵�
 */
public class My3Servlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)//
			throws ServletException, IOException {
		StringBuffer sb = new StringBuffer();
		sb.append("<style>");// ��ʽ
		sb.append("div{background:red}");
		sb.append("</style>");
		sb.append("<div onclick='fn();'>i am div</div>");// html
		sb.append("<script>");// js
		sb.append("function fn(){");
		sb.append("alert('you click me!')");
		sb.append("}");
		sb.append("</script>");
		PrintWriter writer = response.getWriter();
		writer.write(sb.toString());
	}
}
