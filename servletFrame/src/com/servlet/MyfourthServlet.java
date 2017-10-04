package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.jar.Attributes.Name;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyfourthServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuffer str = new StringBuffer();
		str.append("<div>");
		str.append("<form>");
		str.append("name:\t");
		str.append("<input type='text' name='name' id='inna'>");
		str.append("<br>");
		str.append("age:\t");
		str.append("<input type='text' name='age' id='inag' onkeypress=\'EnterPress(event)\' >");
		str.append("</form>");
		str.append("</div>");
		str.append("<script>");
		str.append("function EnterPress(e){ ");
		str.append("var na = document.getElementById('inna').value;");
		str.append("var ag = document.getElementById('inag').value;");
		str.append("var e = e || window.event;");
		str.append(" if(e.keyCode == 13){ ");
		str.append("alert('Name is:'+na);");
		str.append("alert('Age is:'+ag);");
		str.append(" } } ");
		str.append("</script>");
		PrintWriter writer=response.getWriter();
		writer.write(str.toString());
	}
}
