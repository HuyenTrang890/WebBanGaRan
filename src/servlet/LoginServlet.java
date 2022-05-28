package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Admin;
import beans.UserAccount;
import database.LoginDAO;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName =request.getParameter("userName");
		String password = request.getParameter("password");
		
		LoginDAO login = new LoginDAO();
		UserAccount user = login.userCheckLogin(userName, password);
		Admin admin = login.adminCheckLogin(userName, password);
			if(user!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("userName", userName);
				response.sendRedirect(request.getContextPath()+"/ListProduct");
			}else {
			
			if(admin != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userName", userName);
				response.sendRedirect(request.getContextPath()+"/HomeAdminServlet");
			}else {
				 request.setAttribute("errorMsg", "Tài khoản đăng nhập hoặc mật khẩu sai !!!");
				 RequestDispatcher rd = request.getRequestDispatcher("/customer/Login.jsp");
		         rd.forward(request, response);
			}
			}
		
		
		
//		 RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/customer/Login.jsp");
//	        
//	       dispatcher.forward(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
