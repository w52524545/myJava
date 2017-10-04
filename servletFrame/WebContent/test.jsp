<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>getMsql</title>
</head>
<body>
<form>
请输入查询ID:<input type="text" name="idcard"><br>
<input type="button" value="提交" id="butt">
</form>
<div id="d1">
<p id="p"></p>
<table id="TT"></table>
</div>
</body>
<script type="text/javascript">
var Gb=document.getElementById("butt");
Gb.onclick = function () {
	var oInput = document.getElementsByTagName("input")[0];
	var id = oInput.value;
	
	var xml = new XMLHttpRequest();
	xml.onreadystatechange = function () {
		if (xml.readyState == 4 && xml.status == 200){
			var d = document.getElementById("p");
			d.innerHTML="所有联系信息";
			d.align="center";
			
			var arr = ["id","联系方式","联系号码"];
			var T = document.getElementById("TT");
			T.innerHTML="";
			var t1 = document.createElement("thead");
			var t2 = document.createElement("tr");
			for(var i = 0;i<3;i++){
			var t3 = document.createElement("td");
			t3.innerHTML=arr[i];
			t2.appendChild(t3);
			t1.appendChild(t2);
			}
			T.appendChild(t1);
			
			var json = JSON.parse(xml.responseText);
			for(var i=0;i<json.length;i++){
				var tr0 = document.createElement("tr");
				var td1 = document.createElement("td");
				var td2 = document.createElement("td");
				var td3 = document.createElement("td");
				td1.innerHTML = json[i].idcard;
				td2.innerHTML = json[i].desc;
				td3.innerHTML = json[i].contact;
				tr0.appendChild(td1);
				tr0.appendChild(td2);
				tr0.appendChild(td3);
				T.appendChild(tr0);
			}
			T.border="1";
			T.align="center";
		}
}
		xml.open("GET","/servletFrame/seven?idcard="+id,true);
		xml.send();
	}
</script>
</html>