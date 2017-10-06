<%@page import="java.util.Map"%>
<%@ page import="dao.consumerDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html5/loose.dtd">
<html>
<head>
<title>管理系统</title>
<style type="text/css">
</style>
</head>
<body>
	<center>
		欢迎&nbsp&nbsp&nbsp&nbsp ${map['shopName']
		}&nbsp&nbsp店长&nbsp&nbsp${map['name'] }<br />
	</center>
	<div>
		<ul class="list">
			<c:if test="${map['role']!='server' }">
				<li id="l1"><a href="script:void(0)" onclick="getSystem()">
						成员管理</a></li>
			</c:if>
			<li id="l2"><a href="script:void(0)" onclick="getVip()">
					会员管理</a></li>
		</ul>
		<div id="d1">
			<a id="aa"></a>
			<table id="TT"
				style="position: absolute; height: 126px; left: 344px;"></table>
			<div id="df"
				style="position: absolute; left: 480px; width: 240px; height: 190px; border: 1px solid; background-color: GREEN; visibility: hidden;">
				<form action="script:void(0)" style="background-color: GREEN;">
					姓名：<input id="Sname" type="text" name="name"
						style="background-color: RED;"><br /> 手机：<input
						id="Sphone" type="text" name="phone"
						style="background-color: RED;"><br /> 身份证：<input
						id="Sidcard" type="text" name="idcard"
						style="background-color: RED;"><br /> 职位：<input
						id="Srole" type="text" name="role" style="background-color: RED;"><br />
					密码：<input id="Spwd" type="password" name="pwd"
						style="background-color: RED;"><br /> 店名：<input
						id="SshopName" type="text" name="shopName"
						style="background-color: RED;"><br /> 店座机：<input
						id="SshopPhone" type="text" name="shopPhone"
						style="background-color: RED;"><br />
					<button type="button" id="adb" onclick="AddSysAfter()">添加</button>
					<button type="button" id="ddb" onclick="AddSysDd()">取消</button>
				</form>
			</div>
			<div id="fd"
				style="position: absolute; left: 480px; width: 245px; height: 190px; border: 1px solid; background-color: GREEN; visibility: hidden;">
				<form action="script:void(0)" style="background-color: GREEN;">
					姓名：<input id="tSname" type="text" name="name"
						style="background-color: RED;"><br /> 手机：<input
						id="tSconsumerPhone" type="text" name="consumerPhone"
						style="background-color: RED;"><br /> 店座机：<input
						id="tSshopPhone" type="text" name="shopPhone"
						style="background-color: RED;"><br /> 服务电话：<input
						id="tSserverPhone" type="text" name="serverPhone"
						style="background-color: RED;"><br /> 金额：<input
						id="tSbalance" type="text" name="balance"
						style="background-color: RED;"><br />
					<button type="button" id="tadb" onclick="AddCouAfter()">添加</button>
					<button type="button" id="tddb" onclick="AddCouDd()">取消</button>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var role = "${map['role']}";
	var a = document.getElementById("aa");
	function getSystem() {
		a.innerHTML = "添加成员";
		a.href = "script:void(0)";
		a.onclick = AddSysBefore;
		var xml = new XMLHttpRequest();
		xml.onreadystatechange = function() {
			if (xml.readyState == 4 && xml.status == 200) {
				var T = document.getElementById("TT");
				T.innerHTML = "";
				var arr = [ "姓名", "手机", "职位", "ID", "店名", "店座机" ];
				var t1 = document.createElement("thead");
				var t2 = document.createElement("tr");
				for (var i = 0; i < 6; i++) {
					var t3 = document.createElement("td");
					t3.innerHTML = arr[i];
					t2.appendChild(t3);
					t1.appendChild(t2);
				}
				T.appendChild(t1);

				var json = JSON.parse(xml.responseText);
				for (var i = 0; i < json.length; i++) {
					var tr0 = document.createElement("tr");
					var td1 = document.createElement("td");
					var td2 = document.createElement("td");
					var td3 = document.createElement("td");
					var td4 = document.createElement("td");
					var td5 = document.createElement("td");
					var td6 = document.createElement("td");
					td1.innerHTML = json[i].name;
					td2.innerHTML = json[i].phone;
					td3.innerHTML = json[i].role;
					td4.innerHTML = json[i].idcard;
					td5.innerHTML = json[i].shopName;
					td6.innerHTML = json[i].shopPhone;
					tr0.appendChild(td1);
					tr0.appendChild(td2);
					tr0.appendChild(td3);
					tr0.appendChild(td4);
					tr0.appendChild(td5);
					tr0.appendChild(td6);
					T.appendChild(tr0);
				}
				T.border = "1";
				T.align = "center";
			}
		}
		if (role == 'admin') {
			xml.open("POST", "/BarberShop/getAllSys", true);
		} else if (role == 'manager') {
			xml.open("POST", "/BarberShop/getSerSys", true);
		}
		xml.send();
	}

	function getVip() {
		a.innerHTML = "添加会员";
		a.href = "script:void(0)";
		a.onclick = AddCouBefore;
		var xml = new XMLHttpRequest();
		xml.onreadystatechange = function() {
			if (xml.readyState == 4 && xml.status == 200) {
				var T = document.getElementById("TT");
				T.innerHTML = "";
				var arr = [ "姓名", "手机", "服务员手机", "店座机", "余额" ];
				var t1 = document.createElement("thead");
				var t2 = document.createElement("tr");
				for (var i = 0; i < 5; i++) {
					var t3 = document.createElement("td");
					t3.innerHTML = arr[i];
					t2.appendChild(t3);
					t1.appendChild(t2);
				}
				T.appendChild(t1);

				var json = JSON.parse(xml.responseText);
				for (var i = 0; i < json.length; i++) {
					var tr0 = document.createElement("tr");
					var td1 = document.createElement("td");
					var td2 = document.createElement("td");
					var td3 = document.createElement("td");
					var td4 = document.createElement("td");
					var td5 = document.createElement("td");
					td1.innerHTML = json[i].name;
					td2.innerHTML = json[i].consumerPhone;
					td3.innerHTML = json[i].serverPhone;
					td4.innerHTML = json[i].shopPhone;
					td5.innerHTML = json[i].balance;
					tr0.appendChild(td1);
					tr0.appendChild(td2);
					tr0.appendChild(td3);
					tr0.appendChild(td4);
					tr0.appendChild(td5);
					T.appendChild(tr0);
				}
				T.border = "1";
				T.align = "center";
			}
		}
		xml.open("POST", "/BarberShop/getcou", true);
		xml.send();
	}

	var df = document.getElementById("df");
	function AddSysBefore() {
		df.style.visibility = "visible";
	}

	function AddSysAfter() {
		var Sname = document.getElementById("Sname");
		var Sphone = document.getElementById("Sphone");
		var Sidcard = document.getElementById("Sidcard");
		var Srole = document.getElementById("Srole");
		var Spwd = document.getElementById("Spwd");
		var SshopName = document.getElementById("SshopName");
		var SshopPhone = document.getElementById("SshopPhone");
		var name = Sname.value;
		var phone = Sphone.value;
		var idcard = Sidcard.value;
		var role = Srole.value;
		var pwd = Spwd.value;
		var shopName = SshopName.value;
		var shopPhone = SshopPhone.value;

		var xml = new XMLHttpRequest();
		xml.onreadystatechange = function() {
			if (xml.readyState == 4 && xml.status == 200) {
				var json = JSON.parse(xml.responseText);
				alert("增加成功！");
				Sname.value = "";
				Sphone.value = "";
				Sidcard.value = "";
				Srole.value = "";
				Spwd.value = "";
				SshopName.value = "";
				SshopPhone.value = "";
				df.style.visibility = "hidden";
				getSystem();
			}
		}
		xml.open("GET", "/BarberShop/AddSys?name=" + name + "&phone=" + phone
				+ "&idcard=" + idcard + "&role=" + role + "&pwd=" + pwd
				+ "&shopName=" + shopName + "&shopPhone=" + shopPhone, true);
		xml.send();
	}

	function AddSysDd() {
		var Sname = document.getElementById("Sname");
		var Sphone = document.getElementById("Sphone");
		var Sidcard = document.getElementById("Sidcard");
		var Srole = document.getElementById("Srole");
		var Spwd = document.getElementById("Spwd");
		var SshopName = document.getElementById("SshopName");
		var SshopPhone = document.getElementById("SshopPhone");
		Sname.value = "";
		Sphone.value = "";
		Sidcard.value = "";
		Srole.value = "";
		Spwd.value = "";
		SshopName.value = "";
		SshopPhone.value = "";
		df.style.visibility = "hidden";
	}

	var fd = document.getElementById("fd");
	function AddCouBefore() {
		fd.style.visibility = "visible";
	}

	function AddCouAfter() {
		var Sname = document.getElementById("tSname");
		var SconsumerPhone = document.getElementById("tSconsumerPhone");
		var SshopPhone = document.getElementById("tSshopPhone");
		var SserverPhone = document.getElementById("tSserverPhone");
		var Sbalance = document.getElementById("tSbalance");
		var name = Sname.value;
		var consumerPhone = SconsumerPhone.value;
		var shopPhone = SshopPhone.value;
		var serverPhone = SserverPhone.value;
		var balance = Sbalance.value;

		var xml = new XMLHttpRequest();
		xml.onreadystatechange = function() {
			if (xml.readyState == 4 && xml.status == 200) {
				var json = JSON.parse(xml.responseText);
				alert("增加成功！");
				Sname.value = "";
				SconsumerPhone.value = "";
				SshopPhone.value = "";
				SserverPhone.value = "";
				Sbalance.value = "";
				fd.style.visibility = "hidden";
				getVip();
			}
		}
		xml.open("GET", "/BarberShop/AddCou?name=" + name + "&consumerPhone="
				+ consumerPhone + "&shopPhone=" + shopPhone + "&serverPhone="
				+ serverPhone + "&balance=" + balance, true);
		xml.send();
	}

	function AddCouDd() {
		var Sname = document.getElementById("tSname");
		var SconsumerPhone = document.getElementById("tSconsumerPhone");
		var SshopPhone = document.getElementById("tSshopPhone");
		var SserverPhone = document.getElementById("tSserverPhone");
		var Sbalance = document.getElementById("tSbalance");
		Sname.value = "";
		SconsumerPhone.value = "";
		SshopPhone.value = "";
		SserverPhone.value = "";
		Sbalance.value = "";
		fd.style.visibility = "hidden";
	}
</script>
</html>