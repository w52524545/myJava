package dao;

import java.util.Map;

public interface consumerDao {
	public Map<String, Object> findconsumerPhone(String consumerPhone);
	public Map<String, Object> findmanagerPhone(String consumerPhone);
	public void addBalance(Map<String, Object> map0,Map<String, Object> map1);
}
