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
	private static QcCloseSqlSessionInterface cb = null;// 回调接口
	private static SqlSession sqlSession = null;// sqlSession对象

	static {
		String res = "mybatis-config.xml";// 获取配置文件
		try {
			// 加载配置文件
			InputStream config = Resources.getResourceAsStream(res);
			// 创建会话工厂
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(config);
			// 创建SqlSession
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

	// 根据id查询信息
	@Test
	public void findById() {
		// 操作数据库
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

