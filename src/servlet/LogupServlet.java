package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserAccount;
import database.DatabaseConnection;
import database.LogupDAO;

/**
 * Servlet implementation class LogupServlet
 */
@WebServlet("/logup")
public class LogupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String address = request.getParameter("address");

		UserAccount user = new UserAccount(userName, name, email, telephone, password, address);

		LogupDAO logup = null;
		
			logup = new LogupDAO(DatabaseConnection.getConnection());
		
		if (logup.userLogup(user)) {
			request.setAttribute("Message",
					"Bạn đã tạo tài khoản thành công. Mời bạn đăng nhập <a href='/customer/Login.jsp'>tại đây!</a>");
			RequestDispatcher rd = request.getRequestDispatcher("/customer/Logup.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("errMessage", "Tạo tài khoản thất bại hãy thử lại!!!");
			RequestDispatcher rd = request.getRequestDispatcher("/customer/Logup.jsp");
			rd.forward(request, response);
		}

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
