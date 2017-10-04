<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择商品</title>
</head>
<body>
<center>商品显示</center>
<table width="424" height="583" border="0" align="center">
<tr>
<td width="190">
<img src="images/arrow.png" width="150" height="150"/>
</td>
<td width="224">
<img src="images/lock-open.png" width="150" height="150"/>
</td>
</tr>
<tr>
<td>HP笔记本</td>
<td>移动硬盘</td>
</tr>
<tr>
<td>价格:6666元</td>
<td>价格：7000元</td>
</tr>
<tr>
<td>
<form action="add?id=0001&name=HP笔记本&price=6666">
<button>加入购物车</button>
</form>
</td>
<td>
<form action="add?id=0002&name=移动硬盘&price=7000">
<button>加入购物车</button>
</form>
</td>
</tr>
</table>
</body>
</html>