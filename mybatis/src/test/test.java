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

import user.User;

public class test {
	public static void main(String[] args) {
		SqlSession sqlSession = null;// sqlSession����
		String res = "mybatis-config.xml";// ��ȡ�����ļ�
		
		try {
			// ���������ļ�
			InputStream config = Resources.getResourceAsStream(res);
			// �����Ự����
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(config);
			// ����SqlSession
			sqlSession = sqlSessionFactory.openSession();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
//		List<User> list = (List) sqlSession.selectList("UserMapper.findChooise", null);
//		for (User u : list) {
//			System.out.println(u.toString());
//		}
		
		Map m = new HashMap();
		m.put("tableName", "_user");
		m.put("field", "`"+"name"+"`");
		m.put("value", "'"+"lucy"+"'");
		m.put("fid", "uid");
		m.put("id", 2);
		sqlSession.update("UserMapper.Update", m);
		sqlSession.commit();
		sqlSession.close();
	
//		BeginApp beginApp = new BeginApp();
//		beginApp.insert();
//		beginApp.findById();
//		beginApp.findList();
	}
}