package adminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Shopping.ShoppingCart;
import beans.ListProductBean;
import beans.Product;

/**
 * Servlet implementation class HomeAdminServlet
 */
@WebServlet("/HomeAdminServlet")
public class HomeAdminServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		ListProductBean bean = (ListProductBean) session.getAttribute("listBean");
		if (bean == null) {
			bean = new ListProductBean();
			session.setAttribute("listBean", bean);
		}
		ShoppingCart scart = (ShoppingCart) session.getAttribute("scart");
		if (scart == null) {
			scart = new ShoppingCart();

			session.setAttribute("scart", scart);
		}
		// session.invalidate();
		String nextPage = "/Admin/HomeAdmin.jsp";
		String action = request.getParameter("action");
		if (action != null) {
			String id = request.getParameter("id");
			if (action.equals("Buy Now")) {
				id = request.getParameter("id");
				Product product = bean.getProduct(id);
				scart.add(id, product);
			}
			if (action.equals("Edit")) {
				Product product = bean.getProduct(id);
				session.setAttribute("current", product);
				nextPage = "/Admin/EditProductAdmin.jsp";

			}
			if (action.equals("Delete")) {
				bean.deleteProduct(id);
			}
			if (action.equals("Add")) {
				nextPage = "/Admin/NewProductAdmin.jsp";

				if (action.equals("Next")) {
					bean.next();
				} else if (action.equals("Prev")) {
					bean.prev();
				} else {

					if (action.equals("Details")) {
						Product product = bean.getProduct(id);
						session.setAttribute("current", product);
						nextPage = "/Admin/ProductDetailAdmin.jsp";

					}
				}
			}
		}

		// Forward to the jsp page for rendering
		request.getRequestDispatcher(nextPage).forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
