package com.skip;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 这里用注解来实现servlet之间的跳转
 * 
 * 并传递request对象
 * 
 * 注意: 请求这个servlet的时候,需要在请求路径中带上name这个参数.也就是:
 * 
 * http://localhost:8080/servletFrame/skip1?name=xxx
 * 
 * 目的是从这个servlet中传递request,在skip2中取出参数
 */
@WebServlet("/skip1")
public class Skip1Servlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) //
			throws ServletException, IOException {
		request.getRequestDispatcher("/skip2").forward(request, response);
	}
}
