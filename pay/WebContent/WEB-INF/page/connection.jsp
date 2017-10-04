<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- 设置自动提交-->
<body onload="javascript:document.forms[0].submit()">
<form name="yeepay" action="https://www.yeepay.com/app-merchant-proxy/node" method="post">
<!-- 请求命令，在线支付为buy-->
<input type="hidden" name="p0_Cmd" value="${messageType}">
<input type="hidden" name="p1_MerId" value="${merchantID}"><!-- 商家id-->
<input type="hidden" name="p2_Order" value="${orderId}"> 	<!-- 交易单号-->
<input type="hidden" name="p3_Amt" value="${amount}">  	<!-- 订单金额-->
<input type="hidden" name="p4_Cur" value="${currency}">  	<!-- 货币单位-->
<input type="hidden" name="p5_Pid" value="${productId}">	<!-- 商品id-->
<input type="hidden" name="p6_Pcat" value="${productCat}">	<!-- 商品种类-->
<input type="hidden" name="p7_Pdesc" value="${productDesc}">	<!-- 商品描述-->
<input type="hidden" name="p8_Url" value="${merchantCallbackURL}">	<!-- 交易结果地址-->

<!-- 需要填写收货信息 0：不需要   	 1：需要-->
<input type="hidden" name="p9_SAF" value="${addressFlag}"> 
<input type="hidden" name="pa_MP" value="${sMctproperties}">	<!-- 商家扩展信息-->
<input type="hidden" name="pd_FrpId" value="${frpId}">	<!-- 银行id-->

<!-- 应答机制   	为“1”：需要应答机制；	为“0”：不需要应答机制-->
<input type="hidden" name="pr_NeedResponse" value="0">
<input type="hidden" name="hmac" value="${hmac}">	<!-- 验证码-->
</form>
</body>
</html>