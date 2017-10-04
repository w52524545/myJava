package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * "/My2Filter"是这个filter的名字
 *
 * "servletNames = { "MyFirstServlet" }"是需要过滤的servlet的类名
 * 
 * 这里需要注意的是:
 * 
 * 在web.xml中配置了一个过滤器,但是那个过滤配置的url-pattern是" /*  "。这是模糊匹配
 * 
 * 而这里配置了详细的过滤的servlet,也就是"MyFirstServlet","MySecondServlet"两个servlet
 * 
 * 所以当请求"MyFirstServlet","MySecondServlet"两个servlet的时候，会匹配到两个过滤器
 * 
 * 而且这两个过滤器都会执行
 * 
 */
@WebFilter(urlPatterns = { "/My2Filter" }, servletNames = { "MyFirstServlet", "MySecondServlet" })
public class My2Filter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("My2Filter working");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
