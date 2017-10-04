package dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class asdf {
	public static void main(String[] args) {
		Connection conn = DBManager.conn;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM student;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString("idcard");
				System.out.println(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
