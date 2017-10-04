<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    List<Map<String, Object>> list = (List<Map<String, Object>>) request.getAttribute("lists");
    if (list == null || list.size() < 1) {
        out.print("数据库中没有数据");
    } else {
%>
 
<div class="head" align="center">所有联系信息</div>
<table border="1" align="center">
    <thead>
        <tr align="center">
            <td><b>id</b></td>
            <td><b>联系方式</b></td>
            <td><b>联系号码</b></td>
        </tr>
    </thead>
    <%
        for (int i = 0; i < list.size(); i++) {
    %>
    <tr align="center">
        
        <td><%=list.get(i).get("idcard")%></td>
        <td><%=list.get(i).get("desc")%></td>
        <td><%=list.get(i).get("contact")%></td>
    </tr>
    <%
        }}
    %>
</table>
</body>
</html>