<%@ page import="dao.UserDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登陆成功</title>
</head>
<body>
	<center>
		通过controller访问<br /> 
		欢迎 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		${requestScope.map.get("userName") }<br />
	</center>
</body>
</html>
