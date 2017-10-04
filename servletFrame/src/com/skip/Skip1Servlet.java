package com.skip;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ������ע����ʵ��servlet֮�����ת
 * 
 * ������request����
 * 
 * ע��: �������servlet��ʱ��,��Ҫ������·���д���name�������.Ҳ����:
 * 
 * http://localhost:8080/servletFrame/skip1?name=xxx
 * 
 * Ŀ���Ǵ����servlet�д���request,��skip2��ȡ������
 */
@WebServlet("/skip1")
public class Skip1Servlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) //
			throws ServletException, IOException {
		request.getRequestDispatcher("/skip2").forward(request, response);
	}
}
