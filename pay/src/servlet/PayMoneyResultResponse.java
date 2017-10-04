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
				String message = "������Ϊ:" + orderOId + "�Ķ���֧���ɹ���";
				message += "���û�֧����" + amount + "Ԫ";
				message += "�����׽��֪ͨ���ͣ�";
				if ("1".equals(bType)) {
					message += "������ض���";
				} else if ("2".equals(bType)) {
					message += "�ױ�֧�����غ�̨����֪ͨ";
				}
				message += ",�ױ�����ϵͳ�еĶ�����Ϊ��" + sTrxId;
				request.setAttribute("message", message);
			} else {
				request.setAttribute("message", "�û�֧��ʧ��");
			}
		} else {
			request.setAttribute("message", "������Դ���Ϸ�");
		}
		request.getRequestDispatcher("/WEB-INF/page/payMoneyResult.jsp").forward(request, response);
	}
}
