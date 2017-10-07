package dao;

import java.util.List;
import java.util.Map;

public interface consumerDao {
	public Map<String, Object> findconsumerPhone(String consumerPhone);

	public Map<String, Object> findmanagerPhone(String consumerPhone);

	public void addBalance(Map<String, Object> map0, Map<String, Object> map1);

	public List<Map<String, Object>> selectAllSys();

	public List<Map<String, Object>> selectser();

	public List<Map<String, Object>> selectcon();

	public void AddSys(Map<String, Object> map);

	public void AddCou(Map<String, Object> map);

	public void deleteSys(String rn);

	public void deleteCou(String rn);
}
