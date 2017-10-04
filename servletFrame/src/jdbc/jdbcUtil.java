package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class jdbcUtil {
	private static String jdbcDriver = "com.mysql.jdbc.Driver";// mysql连接驱动,无需改
	private static String jdbcUrl = "jdbc:mysql://localhost:3306/zdy";
	private static String jdbcuser = "root"; // 数据库用户名
	private static String jdbcpwd = "201314"; // 数据库密码
	private static Connection con=null;
	
	public jdbcUtil() {
		try {
			Class.forName(jdbcDriver);// 加载mysql驱动类
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getCon() {   //getConnection()之后才能getCon()
		return con;
	}
	
	public static Connection getConnection() {
		try {
			con = DriverManager.getConnection(jdbcUrl, jdbcuser, jdbcpwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static Statement getStatement() {
		Statement sta =null;
		try {
			sta=con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sta;
	}
	
	public static PreparedStatement getPreparedStatement(String sql) {
		PreparedStatement pre =null;
		
		try {
			pre=con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pre;
	}
	
	
	
	public static void close(Connection con,PreparedStatement st,ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection con,Statement st,ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection con,PreparedStatement st) {
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection con,Statement st) {
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
