package com.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Ŀ��: �����servlet�л�ȡsession,��ȥ����session���������
 */
public class SessionDemoGetServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) //
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String addr = (String) session.getAttribute("addr");
		response.getWriter().write(addr);
	}
}
