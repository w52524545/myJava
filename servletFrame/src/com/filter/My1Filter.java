package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 这个过滤器配置在web.xml文件中
 */
public class My1Filter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		System.out.println("My1Filter working");
		chain.doFilter(req, res);// 这句话的意思是,继续执行请求.如果不调用chain的doFilter方法,那么就不在继续执行了
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}
