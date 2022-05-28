package adminServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ListBill;

/**
 * Servlet implementation class BillServlet
 */
@WebServlet("/Bill")
public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BillServlet() {
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
		HttpSession session = request.getSession();
		ListBill bill = (ListBill) session.getAttribute("listBill");
		if (bill == null) {
			bill = new ListBill();
			session.setAttribute("listBill", bill);
		}

		String nextPage = "ListBill.jsp";
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("Next")) {
				bill.next();
			} else if (action.equals("Prev")) {
				bill.prev();

			}
		}

		// Forward to the jsp page for rendering
		request.getRequestDispatcher("/Admin/" + nextPage).forward(request, response);
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
