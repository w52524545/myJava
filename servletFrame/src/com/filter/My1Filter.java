package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * ���������������web.xml�ļ���
 */
public class My1Filter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		System.out.println("My1Filter working");
		chain.doFilter(req, res);// ��仰����˼��,����ִ������.���������chain��doFilter����,��ô�Ͳ��ڼ���ִ����
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}
