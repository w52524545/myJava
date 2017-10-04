package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.PanyMoneyTool;
import tool.ReadConfigInfo;

public class PayMoneyResultResponse extends HttpServlet {
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
		String merchantID = ReadConfigInfo.getValue("p1_MerId");
		String keyValue = ReadConfigInfo.getValue("keyValue");
		String sCmd = request.getParameter("r0_Cmd");
		String sResultCode = request.getParameter("r1_Code");
		String sTrxId = request.getParameter("r2_TrxId");
		String amount = request.getParameter("r3_Amt");
		String currency = request.getParameter("r4_Cur");
		String productId = request.getParameter("r5_Pid");
		String orderOId = request.getParameter("r6_Order");
		String userId = request.getParameter("r7_Uid");
		String mp = request.getParameter("r8_MP");
		String bType = request.getParameter("r9_BType");
		@SuppressWarnings("unused")
		String rb_BankId = request.getParameter("rb_BankId");
		@SuppressWarnings("unused")
		String rp_PayDate = request.getParameter("rp_PayDate");
		String hmac = request.getParameter("hmac");
		boolean result = PanyMoneyTool.verifyCallback(hmac, merchantID, sCmd, sResultCode, sTrxId, amount, currency,
				productId, orderOId, userId, mp, bType, keyValue);
		if (result) {
			if ("1".equals(sResultCode)) {
				String message = "订单号为:" + orderOId + "的订单支付成功了";
				message += "，用户支付了" + amount + "元";
				message += "，交易结果通知类型：";
				if ("1".equals(bType)) {
					message += "浏览器重定向";
				} else if ("2".equals(bType)) {
					message += "易宝支付网关后台程序通知";
				}
				message += ",易宝订单系统中的订单号为：" + sTrxId;
				request.setAttribute("message", message);
			} else {
				request.setAttribute("message", "用户支付失败");
			}
		} else {
			request.setAttribute("message", "数据来源不合法");
		}
		request.getRequestDispatcher("/WEB-INF/page/payMoneyResult.jsp").forward(request, response);
	}
}
