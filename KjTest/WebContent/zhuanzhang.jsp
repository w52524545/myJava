<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>转账</title>
</head>
<body>
	<form align="center">
		对方id：<input type="text" name="GetId" id="Get"><br> 你的id：<input
			type="text" name="LostId" id="lost"><br> 转账金额：<input
			type="text" name="money" id="mon"><br> <input
			type="button" value="转账" id="but">
	</form>
</body>
<script type="text/javascript">
	var Gb = document.getElementById("but");
	Gb.onclick = function() {
		var Get = document.getElementsByTagName("input")[0].value;
		var Lost = document.getElementsByTagName("input")[1].value;
		var money = document.getElementsByTagName("input")[2].value;
		var xml = new XMLHttpRequest();
		xml.onreadystatechange = function() {
			if (xml.readyState == 4 && xml.status == 200) {
				alter("转账成功！")
			}
		}
			xml.open("GET", "mon?GetId=" + Get + "&LostId=" + Lost + "&money="
					+ money, true);
			xml.send();
	}
</script>
</html>