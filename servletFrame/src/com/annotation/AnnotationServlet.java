package com.annotation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 目的: 了解注解
 * 
 * web.xml配置文件的目的就是告诉web容器,需要加载这个servlet,
 * 
 * 而注解也一样可以实现
 * 
 * 这个servlet并没有配置在web.xml中,但是使用了注解@WebServlet
 * 
 * '/as' 就相当于url-pattern中的配置
 */
@WebServlet("/as")
public class AnnotationServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) //
			throws ServletException, IOException {
		response.getWriter().write("im AnnotationServlet ,and you touch me!");
	}
}
