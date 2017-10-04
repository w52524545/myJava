<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
</head>
<body>
	<form action="loginok" method="post" onsubmit="return goWelcome()">
		手机号：<input type="text" id="consumerPhone" name="consumerPhone">
		<span id="d1"></span> <br />
		<button type="button" id="code">获取验证码</button>
		<br /> 验证码：<input type="text" name="check"> <span id="d2"></span>
		<br /> <input type="hidden" id="checkcode"> <input
			type="submit" id="ok" value="登陆">
	</form>
</body>
<script type="text/javascript">
	var bu = document.getElementById("code");
	bu.onclick = function() {
		var p = document.getElementsByTagName("input")[0];
		var phone = p.value;
		var oInput = document.getElementsByTagName("input")[1];
		var code = oInput.value;

		var xml = new XMLHttpRequest();
		xml.onreadystatechange = function() {
			if (xml.readyState == 4 && xml.status == 200) {
				var d1 = document.getElementById("d1");
				var json = JSON.parse(xml.responseText);
				var checkcode = document.getElementById("checkcode");
				d1.innerHTML = "";
				if (json[phone] == "0") {
					d1.innerHTML = "请先注册！";
					d1.style.color = "red";
				} else {
					checkcode.value = json[phone];
					oInput.value = json[phone];
				}
			}
		}
		xml.open("POST", "/BarberShop/getCheckCode?consumerPhone=" + phone,
				true);
		xml.send();
	}

	function goWelcome() {
		var check = document.getElementsByTagName("input")[2];
		var checkcode = check.value;
		var oInput = document.getElementsByTagName("input")[1];
		var code = oInput.value;
		var d2 = document.getElementById("d2");
		d2.innerHTML = "";
		if (checkcode != code || code == "") {
			d2.innerHTML = "验证码错误！"
			d2.style.color = "red";
			return false;
		}
		return true;

	}
</script>
</html>