package servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import DBCP.DBManager;

public class GetMoney {
	public static Connection conn = null;
	public static PreparedStatement sta = null;
	public static ResultSet rs = null;
	public static Savepoint sp;

	static {
		conn = DBManager.conn;
	}

	public void zhuan(String GetId, String LostId, String money) {
		try {
			conn.setAutoCommit(false);
			sta = conn.prepareStatement("UPDATE money set balance=balance-" + money + " where sid=" + LostId + ";");
			sta.executeUpdate();
			sta = conn.prepareStatement("UPDATE money set balance=balance+" + money + " where sid=" + GetId + ";");
			sta.executeUpdate();
			sp = conn.setSavepoint(); // 设置保存点
			// int i = 1 / 0;
			conn.commit();// 如果上面的执行都没问题，再提交。
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (sp != null) {// 只简单说明,实际还要判断conn是不是null
			try {
				conn.rollback(sp);
				conn.commit(); // 回滚到保存点再执行提交
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

}
