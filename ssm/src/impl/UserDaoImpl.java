package impl;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import dao.UserDao;

@Component
public class UserDaoImpl implements UserDao {
	SqlSessionTemplate SqlSession;

	public SqlSessionTemplate getSqlSession(String id, String user, String uid) {
		return SqlSession;

	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		SqlSession = sqlSession;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map findUserById(String id) {
		Map user = SqlSession.selectOne("mapper.UserMapper.selectUserById", id);
		return user;
	}

}
