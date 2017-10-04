package com.servlet;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	private static String jdbcDriver = "com.mysql.jdbc.Driver";// mysql杩炴帴椹卞姩,鏃犻渶鏀�
	/**
	 * jdbc :mysql://192.168.0.176 : 鏁版嵁搴撶殑鍦板潃. 3306 :mysql鏁版嵁搴撶殑绔彛 test :鏁版嵁搴撶殑鍚嶇О
	 */
	private static String jdbcUrl = "jdbc:mysql://localhost:3306/student";
	private static String jdbcuser = "root"; // 鏁版嵁搴撶敤鎴峰悕
	private static String jdbcpwd = "201314"; // 鏁版嵁搴撳瘑鐮�
	private static Connection conn;
	public static Statement st;
	static {// 闈欐�佸潡锛屼竴寮�鍚姩灏卞垱寤哄繀椤荤殑瀵硅薄銆�
		try {
			Class.forName(jdbcDriver);// 鍔犺浇mysql椹卞姩绫�
			conn = DriverManager.getConnection(jdbcUrl, jdbcuser, jdbcpwd); // 椹卞姩鍒╃敤椹卞姩鍦板潃锛屾暟鎹簱鐢ㄦ埛鍚嶏紝瀵嗙爜鍒涘缓杩炴帴
			st = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			String sql = "SELECT\r\n" + 
					"	student.s_name,\r\n" + 
					"	chooise.cc_id,\r\n" + 
					"	chooise.cs_id,\r\n" + 
					"	course.course,\r\n" + 
					"	course.course_time\r\n" + 
					"FROM\r\n" + 
					"	student\r\n" + 
					"JOIN chooise ON student.s_id = chooise.cs_id\r\n" + 
					"JOIN course ON chooise.cc_id = course.course_id\r\n" + 
					"WHERE\r\n" + 
					"	student.s_id = 201402040215;";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("s_name");
				String _course = rs.getString("course");
				String course_time = rs.getString("course_time");
				System.out.println("name:" + name  +"\ncourse:"+_course+"\ncourse time:"+course_time);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
