package shoppingCar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sourse.ShoppingCart;

public class AddShoppingCartServlet extends HttpServlet{
	private static final long serialVersionUID = -4871749793762313074L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ShoppingCart cart = (ShoppingCart) session.getAttribute("shoppingcart");
		if(cart==null) {
			cart=new ShoppingCart();
			session.setAttribute("shoppingcart", cart);
		}
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String quantity = request.getParameter("q");
		String price = request.getParameter("price");
		if(StringTool) {
			
		}
	}
}
