package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ListProductBean;
import beans.ListUser;
import beans.UserAccount;
import database.UserDao;

/**
 * Servlet implementation class InformationServlet
 */
@WebServlet("/Information")
public class InformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InformationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserAccount user = null;
		HttpSession session = request.getSession();
		ListUser bean = (ListUser) session.getAttribute("listUser");
		if (bean == null) {
			bean = new ListUser();
			session.setAttribute("listUser", bean);
		}

		String nextPage = "/customer/InforUser.jsp";
		String action = request.getParameter("action");

		String userName = request.getParameter("userName");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String address = request.getParameter("address");
		user = bean.getEmployee(userName);

		session.setAttribute("user", user);
		if (action != null) {

			UserAccount userAccount = new UserAccount(userName, name, email, telephone, password, address);
			bean.updateUser(userAccount);
			nextPage = "/customer/InforUser.jsp";
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
