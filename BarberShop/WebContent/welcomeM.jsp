<%@page import="java.util.Map"%>
<%@ page import="dao.consumerDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html5/loose.dtd">
<html>
<head>
<title>管理系统</title>
<style type="text/css">
</style>
</head>
<body>
	<div>
		<ul class="list">
			<li id="l1"><a href="" target="mainFrame" onclick=""> 成员管理</a></li>
			<li id="l2"><a href="" target="mainFrame" onclick=""> 会员管理</a></li>
		</ul>
		<div>
			<iframe name="mainFrame" id="mainFrame" frameborder="0"
				style="margin: 0px auto; width: 100%; height: 620px">
				#document </iframe>
		</div>
	</div>
	<center>
		欢迎&nbsp&nbsp&nbsp&nbsp ${map['shopName']
		}&nbsp&nbsp店长&nbsp&nbsp${map['name'] }<br />
	</center>
</body>
</html>