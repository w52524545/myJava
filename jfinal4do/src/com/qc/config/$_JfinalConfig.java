package com.qc.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import com.qc.controller.HelloController;
import com.qc.controller.UserController;
import com.qc.entity.User;
import com.qc.interceptor.QcControllerIntercepter;
import com.qc.interceptor.QcServiceInterceptor;

public class $_JfinalConfig extends JFinalConfig {

	public static void main(String[] args) {
		JFinal.start("WebRoot", 80, "/");
	}

	public void configConstant(Constants me) {
		me.setDevMode(true);
	}

	public void configRoute(Routes me) {
		// me.addInterceptor(new FrontInterceptor());
		me.add("/hello", HelloController.class);
		me.add("/user", UserController.class);
	}

	public void configEngine(Engine me) {
	}

	public void configPlugin(Plugins me) {
		loadPropertyFile("dbconfig.properties");
		DruidPlugin dp = new DruidPlugin(getProperty("url"), getProperty("username"), getProperty("password"));
		me.add(dp);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
		arp.setBaseSqlTemplatePath(PathKit.getRootClassPath());
		arp.addSqlTemplate("sql/user.sql");
		arp.addSqlTemplate("sql/test.sql");
		arp.setDevMode(true);// 打印sql语句
		arp.setShowSql(true);
		me.add(arp);
		arp.addMapping("test_user", "uid", User.class);
	}

	public void configInterceptor(Interceptors me) {
		me.addGlobalActionInterceptor(new QcControllerIntercepter());// 全局拦截器,拦截controller,不拦截普通方法
		// 添加业务层全局拦截器
		me.addGlobalServiceInterceptor(new QcServiceInterceptor());
	}

	public void configHandler(Handlers me) {
	}
}
