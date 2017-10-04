package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogonFormServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		if(session==null) {
			out.print("ʧ��");
			return;
		}
		String save = (String) session.getAttribute("check_code");
		if(save==null) {
			out.print("ʧ��");
			return;
		}
		String check = request.getParameter("check_code");
		if(!save.equals(check)) {
			out.print("��Ч");
			return;
		}
		session.removeAttribute("check_code");
		out.print("�ɹ�");
	}
}
