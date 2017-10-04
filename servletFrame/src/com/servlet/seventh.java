package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;


@WebServlet("/seven")
public class seventh extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String jdbcDriver = "com.mysql.jdbc.Driver";// mysql连接驱动,无需改
	private static String jdbcUrl = "jdbc:mysql://localhost:3306/zdy";
	private static String jdbcuser = "root"; // 数据库用户名
	private static String jdbcpwd = "201314"; // 数据库密码
	private static Connection conn;
	public static PreparedStatement sta;
	public static ResultSet rs;
	static {
		try {
			Class.forName(jdbcDriver);// 加载mysql驱动类
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			conn = DriverManager.getConnection(jdbcUrl, jdbcuser, jdbcpwd); // 驱动利用驱动地址，数据库用户名，密码创建连接
			String id_card=request.getParameter("idcard");
			String sql = "SELECT contact.idcard,contact_desc.`desc`,contact_ext.contact\r\n" + 
					"FROM contact\r\n" + 
					"JOIN contact_ext ON contact_ext.idcard=contact.idcard\r\n" + 
					"JOIN contact_desc on contact_desc.contact_type=contact_ext.contact_type\r\n" + 
					"WHERE contact.idcard=?";
			sta = conn.prepareStatement(sql);
			sta.setString(1, id_card);
			rs = sta.executeQuery();
			ResultSetMetaData rm = rs.getMetaData();
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			while (rs.next()) {
				Map<String, Object> m = new HashMap<String, Object>();
				for (int i = 1; i <= rm.getColumnCount(); i++) {
					m.put(rm.getColumnName(i), rs.getObject(i));
					System.out.println("字段名:"+rm.getColumnName(i)+"\t字段值:"+rs.getObject(i));
				}
				list.add(m);
			}
			request.setAttribute("lists", list);
			String json = JSON.toJSONString(list);
			response.setHeader("Content-type", "text/html;charset=UTF-8"); 
			response.getWriter().write(json);
			//request.getRequestDispatcher("/sqlReturn.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				sta.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
