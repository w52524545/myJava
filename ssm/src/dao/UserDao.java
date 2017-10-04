package dao;
import  java.util.Map;
public interface UserDao {
	public Map<?, ?> findUserById(String id);
}