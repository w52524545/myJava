package com.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * ����Ƕ�sesson�ļ�����������session ��ʱ����������ͻ�ִ��
 * 
 * Ҳ���ǵ�����SessionDemoPutServlet���servlet��ʱ��
 * 
 * ����ʹ�õ���ע��ķ�ʽ��Ҳ���Խ�������������web.xml��
 */
@WebListener
public class My1Listener implements HttpSessionListener {

	public My1Listener() {
	}
	
	//ֻ���ڵ�һ�δ���session ��ʱ��Żᱻ����
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("listener working");
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
	}
}
