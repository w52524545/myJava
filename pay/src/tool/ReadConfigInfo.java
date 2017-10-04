package tool;

import java.util.Properties;

public class ReadConfigInfo {
	private static Properties cache = new Properties();
	static {
		try {
			cache.load(ReadConfigInfo.class.getClassLoader().getResourceAsStream("merchantInfo.properties"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getValue(String key) {
		return cache.getProperty(key);
	}
}
