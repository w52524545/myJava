package c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main {
	public static void main(String[] args) {
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection con = null;

		C3P0Properties c3 = new C3P0Properties();
		c3.getConnection();
		con = C3P0Properties.con;
		String sql = "SELECT * FROM student;";
		try {
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				String na = rs.getString("name");
				String id = rs.getString("idcard");
				System.out.println(na + "  " + id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

		}

	}

}
