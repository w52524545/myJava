package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.PanyMoneyTool;
import tool.ReadConfigInfo;

public class PayMoneyRequest extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String orderid = request.getParameter("orderid");
		String amount = request.getParameter("amount");
		String pd_FrpId = request.getParameter("pd_FrpId");
		String p1_MerId = ReadConfigInfo.getValue("p1_MerId");
		String keyValue = ReadConfigInfo.getValue("keyValue");
		
		String merchantCallbackURL = ReadConfigInfo.getValue("merchantCallbackURL");
		String messageType = "Buy";
		String currency = "CNY";
		String productDesc = "";
		String productCat = "";
		String productId = "";
		String addressFlag = "0";
		String sMctProperties = "";
		String pr_NeedResponse = "0";
		
		String md5hmac = PanyMoneyTool.buildHmac(messageType, p1_MerId, orderid, 
				amount, currency, productId, productCat, productDesc, merchantCallbackURL, 
				addressFlag, sMctProperties, pd_FrpId, pr_NeedResponse, keyValue);
		
		request.setAttribute("messageType", messageType);
		request.setAttribute("merchantID", p1_MerId);
		request.setAttribute("orderId", orderid);
		request.setAttribute("amount", amount);
		request.setAttribute("currency", currency);
		request.setAttribute("productId", productId);
		request.setAttribute("productCat", productCat);
		request.setAttribute("productDesc", productDesc);
		request.setAttribute("merchantCallbackURL", merchantCallbackURL);
		request.setAttribute("addressFlag", addressFlag);
		request.setAttribute("sMctProperties", sMctProperties);
		request.setAttribute("frpId", pd_FrpId);
		request.setAttribute("pr_NeedResponse", pr_NeedResponse);
		request.setAttribute("hmac", md5hmac);
		
		request.getRequestDispatcher("/WEB-INF/page/connection.jsp").forward(request, response);
	}
}
