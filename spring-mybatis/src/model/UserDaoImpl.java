package model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public class UserDaoImpl{

	private SqlSessionTemplate sqlSession;

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	public Map selectUser(String username) {
		return (Map) sqlSession.selectOne("dao.UserMapper.selectUser", username);
	}
	
	public List show() {
		return sqlSession.selectList("dao.UserMapper.show");
	}

	public void insertUser(Map user) {
		sqlSession.insert("dao.UserMapper.insertUser", user);
	}

	public void updateUser(Map user) {
		sqlSession.update("dao.UserMapper.updateUser", user);
	}

	public void deleteUser(int id) {
		sqlSession.delete("dao.UserMapper.deleteUser", id);
	}
}
