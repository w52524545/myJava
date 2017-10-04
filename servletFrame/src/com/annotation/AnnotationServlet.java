package com.annotation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Ŀ��: �˽�ע��
 * 
 * web.xml�����ļ���Ŀ�ľ��Ǹ���web����,��Ҫ�������servlet,
 * 
 * ��ע��Ҳһ������ʵ��
 * 
 * ���servlet��û��������web.xml��,����ʹ����ע��@WebServlet
 * 
 * '/as' ���൱��url-pattern�е�����
 */
@WebServlet("/as")
public class AnnotationServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) //
			throws ServletException, IOException {
		response.getWriter().write("im AnnotationServlet ,and you touch me!");
	}
}
