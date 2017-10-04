package com.qc.entity;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class User extends Model<User> {
	private static final long serialVersionUID = 1L;
	public static final User dao = new User().dao();// 并不是必须的,但是有他更方便

	public void insertUser(String name, String age, String gender, String phone) {
		User user = new User();
		user.set("name", name).set("age", age).set("gender", gender).set("phone", phone);
		user.save();
	}

	public void delUser(String uid) {
		dao.deleteById(uid);
	}

	public void editUser(String uid, String name) {
		dao.findById(uid).set("name", name).update();
	}

	public User getByUid(String uid) {
		return dao.findById(uid);
	}

	public List<User> getUserList(String uid) {
		List<User> list = null;
		list = dao.find("select * from `test_user` where uid<? and age>?", uid, 18);
		return list;
	}

	public Page<User> getPage(int pageNum, int total) {
		Page<User> page = null;
		page = dao.paginate(pageNum, total, "select *", "from test_user ");
		return page;
	}

	// get user by uid with sqlTemplate
	public User getUserByUidWithTemplate(String uid) {
		String sql = Db.getSql("user.findUserByUid");
		return dao.findFirst(sql, uid);
	}

	// get user by uid with sqlTemplate
	public List<User> getUserListByTemplate() {
		String sql = Db.getSql("test.findUserByUid");
		return dao.find(sql);
	}
}
