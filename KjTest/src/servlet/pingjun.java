package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBCP.DBManager;

@WebServlet("/ping")
public class pingjun extends HttpServlet {
	public static PreparedStatement sta = null;
	public static Connection conn = null;
	public static ResultSet rs = null;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		conn = DBManager.conn;
		String sql = "SELECT  stu.`name`,AVG(gr.grade) AS ping\r\n" + "FROM student AS stu \r\n"
				+ "JOIN couse_grade AS gr ON stu.sid=gr.sid\r\n" + "GROUP BY stu.`name`";
		try {
			sta = conn.prepareStatement(sql);
			rs = sta.executeQuery();
			ResultSetMetaData rm = rs.getMetaData();
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			while (rs.next()) {
				Map<String, Object> m = new HashMap<String, Object>();
				for (int i = 1; i <= rm.getColumnCount(); i++) {
					m.put(rm.getColumnName(i), rs.getObject(i));
				}
				list.add(m);
			}
			request.setAttribute("lists", list);
			request.getRequestDispatcher("/pingjun.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
