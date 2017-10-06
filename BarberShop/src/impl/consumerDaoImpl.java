package impl;

import java.util.List;
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

	@Override
	public List<Map<String, Object>> selectAllSys() {
		// TODO Auto-generated method stub
		return SqlSession.selectList("mapper.consumerMapper.selectAllSys");
	}

	@Override
	public List<Map<String, Object>> selectser() {
		// TODO Auto-generated method stub
		return SqlSession.selectList("mapper.consumerMapper.selectser");
	}

	@Override
	public List<Map<String, Object>> selectcon() {
		// TODO Auto-generated method stub
		return SqlSession.selectList("mapper.consumerMapper.selectcon");
	}

	@Override
	public void AddSys(Map<String, Object> map) {
		// TODO Auto-generated method stub
		SqlSession.insert("mapper.consumerMapper.AddSys", map);
	}

	@Override
	public void AddCou(Map<String, Object> map) {
		// TODO Auto-generated method stub
		SqlSession.insert("mapper.consumerMapper.AddCou", map);
	}

}
