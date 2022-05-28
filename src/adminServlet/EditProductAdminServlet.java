package adminServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ListProductBean;
import beans.Product;

/**
 * Servlet implementation class EditEmployee
 */
@WebServlet("/EditProductAdminServlet")
public class EditProductAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ListProductBean bean = (ListProductBean) session.getAttribute("listBean");
		if (bean == null) {
			bean = new ListProductBean();
			session.setAttribute("listBean", bean);
		}

		Product pro = (Product) request.getSession().getAttribute("current");
		String id = pro.getId();
		String title = request.getParameter("title");
		Double price = Double.parseDouble(request.getParameter("price"));
		String descrition = request.getParameter("descrition");

		int amount = Integer.parseInt(request.getParameter("amount"));

		Product e = new Product(id, price, title, descrition, amount);
		bean.updateProduct(e);

		request.getRequestDispatcher("/HomeAdminServlet").forward(request, response);

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
