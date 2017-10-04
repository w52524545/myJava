package com.skip;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 目的是:
 * 
 * 通过skip1传来的request对象,取出参数
 */
@WebServlet("/skip2")
public class Skip2Servlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) //
			throws ServletException, IOException {
		String name = request.getParameter("name");
		if (name != null) {
			response.getWriter().write(name);
		} else {
			response.getWriter().write("name is null");
		}
	}
}
