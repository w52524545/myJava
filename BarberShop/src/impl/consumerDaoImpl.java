package impl;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.consumerDao;

@Service
public class consumerDaoImpl implements consumerDao {
	SqlSessionTemplate SqlSession;

	public SqlSessionTemplate getSqlSession() {
		return SqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		SqlSession = sqlSession;
	}

	@Override
	public Map<String, Object> findconsumerPhone(String consumerPhone) {
		Map<String, Object> consumer = SqlSession.selectOne("mapper.consumerMapper.findconsumerPhone", consumerPhone);
		return consumer;
	}

	@Override
	public Map<String, Object> findmanagerPhone(String consumerPhone) {
		Map<String, Object> manager = SqlSession.selectOne("mapper.consumerMapper.findmanagerPhone", consumerPhone);
		return manager;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void addBalance(Map<String, Object> map0, Map<String, Object> map1) {
		SqlSession.update("mapper.consumerMapper.addBalance", map0);
		SqlSession.insert("mapper.consumerMapper.inHistory", map1);
	}

}
