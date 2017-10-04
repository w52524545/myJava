package com.qc.controller;

import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.qc.entity.User;

public class UserController extends Controller {

	public void addUser() {
		String name = getPara("name");
		String age = getPara("age");
		String gender = getPara("gender");
		String phone = getPara("phone");
		User.dao.insertUser(name, age, gender, phone);
	}

	public void delUser() {
		String uid = getPara("uid");
		User.dao.delUser(uid);
		renderText("ok");
	}

	public void editUser() {
		String uid = getPara("uid");
		String name = getPara("name");
		User.dao.editUser(uid, name);
		renderFreeMarker("/user/addUser.html");
	}

	public void getUser() {
		String uid = getPara("uid");
		User user = User.dao.findById(uid);
		renderJson(user);
	}

	public void getUserList() {
		String uid = getPara("uid");
		List<User> userList = User.dao.getUserList(uid);
		renderJson(userList);
	}

	public void getPage() {
		int pageNum = getParaToInt("pageNum");
		int total = getParaToInt("total");
		Page<User> page = User.dao.getPage(pageNum, total);
		renderJson(page);
	}

	// get user by uid with template
	public void getUserByUidWithTemplate() {
		String uid = getPara("uid");
		User user = User.dao.getUserByUidWithTemplate(uid);
		renderJson(user);
	}

	public void getUserListWithTemplate() {
		List<User> list = User.dao.getUserListByTemplate();
		renderJson(list);
	}
}
