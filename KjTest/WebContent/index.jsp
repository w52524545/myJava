<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请</title>
</head>
<body>
	<form align="center">
		<input type="button" value="查看平均成绩" id="butt"> <input
			type="button" value="查询单个成绩" id="dutt"> <input type="button"
			value="转账" id="zutt">
	</form>
</body>
<script type="text/javascript">
	var bu = document.getElementById("butt");
	bu.onclick = function() {
		window.location.href = "ping";
	}

	var du = document.getElementById("dutt");
	du.onclick = function() {
		window.location.href = "xuanze.jsp";
	}

	var zu = document.getElementById("zutt");
	zu.onclick = function() {
		window.location.href = "zhuanzhang.jsp";
	}
</script>
</html>