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
 * "/My2Filter"�����filter������
 *
 * "servletNames = { "MyFirstServlet" }"����Ҫ���˵�servlet������
 * 
 * ������Ҫע�����:
 * 
 * ��web.xml��������һ��������,�����Ǹ��������õ�url-pattern��" /*  "������ģ��ƥ��
 * 
 * ��������������ϸ�Ĺ��˵�servlet,Ҳ����"MyFirstServlet","MySecondServlet"����servlet
 * 
 * ���Ե�����"MyFirstServlet","MySecondServlet"����servlet��ʱ�򣬻�ƥ�䵽����������
 * 
 * ��������������������ִ��
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
