package com.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 这个是对sesson的监听。当创建session 的时候，这个监听就会执行
 * 
 * 也就是当请求SessionDemoPutServlet这个servlet的时候
 * 
 * 这里使用的是注解的方式，也可以将监听器配置在web.xml中
 */
@WebListener
public class My1Listener implements HttpSessionListener {

	public My1Listener() {
	}
	
	//只有在第一次创建session 的时候才会被调用
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("listener working");
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
	}
}
