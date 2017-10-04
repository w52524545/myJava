package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbcFeng.jdbcUtil;
@WebServlet("/jdb")
public class newJdb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Savepoint save;
	private static jdbcUtil co;
	private static PreparedStatement sta;
	private static Connection con;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		co=new jdbcUtil();
		try {
			co.getConnection();
			con=co.getCon();
			con.setAutoCommit(false);
			String sql1 = "UPDATE sbsmon\r\n" + "SET sbsmon.balance = sbsmon.balance + 20000000\r\n" + "WHERE\r\n"
					+ "	sbsmon.id = 1;";
			sta = co.getPreparedStatement(sql1);
			sta.executeUpdate();

			String sql2 = "UPDATE sbsmon\r\n" + "SET sbsmon.balance = sbsmon.balance - 50\r\n" + "WHERE\r\n"
					+ "	sbsmon.id = 2;";
			sta = co.getPreparedStatement(sql2);
			sta.executeUpdate();

			String sql3 = "UPDATE sbsmon\r\n" + "SET sbsmon.balance = sbsmon.balance - 50\r\n" + "WHERE\r\n"
					+ "	sbsmon.id = 3;";
			sta = co.getPreparedStatement(sql3);
			sta.executeUpdate();

			String sql4 = "UPDATE sbsmon\r\n" + "SET sbsmon.balance = sbsmon.balance - 100\r\n" + "WHERE\r\n"
					+ "	sbsmon.id = 4;";
			sta = co.getPreparedStatement(sql4);
			sta.executeUpdate();

			String sql5 = "UPDATE sbsmon\r\n" + "SET sbsmon.balance = sbsmon.balance - (20000000-200)\r\n" + "WHERE\r\n"
					+ "	sbsmon.id = 5;";
			sta = co.getPreparedStatement(sql5);
			sta.executeUpdate();
			save = con.setSavepoint();
			int i = 10 / 0;
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (con != null && save != null) {
					con.rollback(save);
					con.commit();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			co.close(con,sta);
		}
	}
}
