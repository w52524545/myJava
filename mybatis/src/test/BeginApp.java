package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import user.User;

public class BeginApp {
	private static QcCloseSqlSessionInterface cb = null;// �ص��ӿ�
	private static SqlSession sqlSession = null;// sqlSession����

	static {
		String res = "mybatis-config.xml";// ��ȡ�����ļ�
		try {
			// ���������ļ�
			InputStream config = Resources.getResourceAsStream(res);
			// �����Ự����
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(config);
			// ����SqlSession
			sqlSession = sqlSessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			cb = new QcCloseSqlSessionInterface() {
				public void cb() {
					sqlSession.close();
				}
			};
		}
	}

	@Test
	public void insert() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "jack");
		map.put("gender", 1);
		map.put("uid", 3);
		int insert = sqlSession.insert("UserMapper.insert", map);
		System.out.println(insert);
		sqlSession.commit();
	}

	// ����id��ѯ��Ϣ
	@Test
	public void findById() {
		// �������ݿ�
		User u = (User) sqlSession.selectOne("UserMapper.findById", 1);
		System.out.println(u.toString());
		//cb.cb();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void findList() {
		List<User> list = (List) sqlSession.selectList("UserMapper.findList");
		for (User u : list) {
			System.out.println(u.toString());
		}
		sqlSession.commit();
		cb.cb();
	}

}

