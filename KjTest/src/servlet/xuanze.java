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

import com.alibaba.fastjson.JSON;

import DBCP.DBManager;

@WebServlet("/chooise")
public class xuanze extends HttpServlet {
	public static Connection conn = null;
	public static PreparedStatement sta = null;
	public static ResultSet rs = null;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		conn = DBManager.conn;
		String sid = request.getParameter("sid");
		String sql = "SELECT  stu.`name`,cou.course,gr.grade\r\n" + "FROM student AS stu \r\n"
				+ "JOIN couse_grade AS gr ON stu.sid=gr.sid\r\n" + "JOIN course AS cou ON cou.cid=gr.cid\r\n"
				+ "WHERE stu.sid=?";
		try {
			sta = conn.prepareStatement(sql);
			sta.setString(1, sid);
			rs = sta.executeQuery();
			ResultSetMetaData rm = rs.getMetaData();
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			while (rs.next()) {
				Map<String, Object> m = new HashMap<String, Object>();
				for (int i = 1; i <= rm.getColumnCount(); i++) {
					m.put(rm.getColumnName(i), rs.getObject(i));
					System.out.println("字段名:" + rm.getColumnName(i) + "\t字段值:" + rs.getObject(i));
				}
				list.add(m);
			}
			request.setAttribute("lists", list);
			String json = JSON.toJSONString(list);
			response.setHeader("Content-type", "text/html;charset=UTF-8");
			response.getWriter().write(json);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
