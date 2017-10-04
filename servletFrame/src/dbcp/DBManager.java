package dbcp;

import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DBManager {
	private static final Log log = LogFactory.getLog(DBManager.class);
	private static DataSource dataSource;
	public static Connection conn;
	static {
		Properties dbProperties = new Properties();
		try {
			dbProperties.load(DBManager.class.getClassLoader().getResourceAsStream("dbcp.properties"));
			dataSource = BasicDataSourceFactory.createDataSource(dbProperties);
			conn = dataSource.getConnection();
		} catch (Exception e) {
			log.error("初始化连接池失败：" + e);
		}
	}
}
