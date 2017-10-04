package com.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 目的: 从这个servlet中获取session并存入数据
 */
public class SessionDemoPutServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) //
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("addr", "zhejiang hangzhou binjiang");
		response.getWriter().write("setAttribute over");
	}
}
