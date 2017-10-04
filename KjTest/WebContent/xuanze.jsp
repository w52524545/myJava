<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择查询</title>
</head>
<body>
	<form>
		请输入查询学号:<input type="text" name="sid"><br> <input
			type="button" value="查询" id="butt">
	</form>
	<div id="d1">
		<p id="p"></p>
		<table id="TT"></table>
	</div>
</body>
<script type="text/javascript">
	var Gb = document.getElementById("butt");
	Gb.onclick = function() {
		var oInput = document.getElementsByTagName("input")[0];
		var id = oInput.value;

		var xml = new XMLHttpRequest();
		xml.onreadystatechange = function() {
			if (xml.readyState == 4 && xml.status == 200) {
				var d = document.getElementById("p");
				d.innerHTML = "所有成绩";
				d.align = "center";
				
				var T = document.getElementById("TT");
				T.innerHTML = "";

				var json = JSON.parse(xml.responseText);
				for (var i = 0; i < json.length; i++) {
					var tr0 = document.createElement("tr");
					var td1 = document.createElement("td");
					var td2 = document.createElement("td");
					var td3 = document.createElement("td");
					td1.innerHTML = json[i].name;
					td2.innerHTML = json[i].course;
					td3.innerHTML = json[i].grade;
					tr0.appendChild(td1);
					tr0.appendChild(td2);
					tr0.appendChild(td3);
					T.appendChild(tr0);
				}
				T.border = "1";
				T.align = "center";
			}
		}
		xml.open("GET", "chooise?sid=" + id, true);
		xml.send();
	}
</script>
</html>