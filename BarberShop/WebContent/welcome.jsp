<%@page import="java.util.Map"%>
<%@ page import="dao.consumerDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登陆成功</title>
<style type="text/css">
</style>
</head>
<body>
	<center>
		欢迎&nbsp&nbsp&nbsp&nbsp ${map['name'] }<br /> <a
			href="javascript:chongzhi()">充值</a>
		<div id="d1"
			style="border: 1px solid; width: 400px; height: 100px; visibility: hidden;">
			<form action="">
				手机号：<input type="text" name="consumerPhone"><br /> 充值金额：<input
					type="text" name="cost">元<br />
				<button type="button" id="but">充值</button>
			</form>
		</div>
	</center>
</body>
<script type="text/javascript">
	function chongzhi() {
		var d1 = document.getElementById("d1");
		d1.style.visibility = "visible";
	}

	var but = document.getElementById("but");
	but.onclick = function() {
		var p = document.getElementsByTagName("input")[0];
		var phone = p.value;
		var m = document.getElementsByTagName("input")[1];
		var cost = m.value;

		var xml = new XMLHttpRequest();
		xml.onreadystatechange = function() {
			if (xml.readyState == 4 && xml.status == 200) {
				var json = JSON.parse(xml.responseText);
				var result = "充值成功！余额" + json['balance'] + "元!";
				alert(result);
				p.value = "";
				m.value = "";
				var d1 = document.getElementById("d1");
				d1.style.visibility = "hidden";
			}
		}
		xml.open("POST", "/BarberShop/getBalance?consumerPhone=" + phone
				+ "&cost=" + cost, true);
		xml.send();
	}
</script>
</html>