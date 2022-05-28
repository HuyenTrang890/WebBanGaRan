package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Shopping.ShoppingCart;
import beans.Bill;
import beans.ListProductBean;
import beans.ListUser;
import beans.Product;
import beans.UserAccount;

/**
 * Servlet implementation class ShoppingCart
 */
@WebServlet("/ShoppingCart")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShoppingCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = null;
		Product pr = null;

		HttpSession session = request.getSession();
		ListProductBean bean = (ListProductBean) session.getAttribute("listBean");
		ListUser user = (ListUser) session.getAttribute("listUser");
		if (user == null) {
			user = new ListUser();
			session.setAttribute("listUser", user);
		}
		// Tao attribute cho cart
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		ShoppingCart scart = (ShoppingCart) session.getAttribute("scart");

		if (cart == null) {
			cart = new ShoppingCart();
			session.setAttribute("cart", cart);
		}
		String nextPage = "/customer/MyBag.jsp";
		String action = request.getParameter("action");

		id = request.getParameter("id");

		pr = bean.getProduct(id);
		cart.add(id, pr);

		session.setAttribute("product", pr);
//
		if (action != null) {
			if (action.equals("Checkout")) {

				String userName = request.getParameter("idAcc");
				UserAccount account = user.getEmployee(userName);
				Bill bill = new Bill(userName, scart.getTotal());

				bean.checkOut(bill);
				session.setAttribute("user", bill);
				scart.clearCart();
				nextPage = "/customer/Checkout.jsp";
			}
		}
		request.getRequestDispatcher(nextPage).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
