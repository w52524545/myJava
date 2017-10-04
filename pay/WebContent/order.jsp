<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支付</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/servlet/PayMoneyRequest" method="post"
      name="paymentform">
      订单号：<input type="text" name="orderid">
      应付金额:¥<input type="text" name="amount" size="6">元
      <span class="STYLE3">请选择支付银行</span>
      <input type="radio" name="pd_FrpId" value="CMBCHINA-NET">
      招商银行<input type="radio" name="pd_FrpId" value="ICBC-NET">
      工商银行<input type="radio" name="pd_FrpId" value="ECITIC-NET">
      中信银行
      <input type="submit" value="确认支付" />    
      </form>
</body>
</html>