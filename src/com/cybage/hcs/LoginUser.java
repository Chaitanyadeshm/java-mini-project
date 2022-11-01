package com.cybage.hcs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybage.modal.Users;
import com.cybage.service.HCSService;
import com.cybage.service.HCSServiceImpl;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {
	HCSService service = new HCSServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Users user = service.loginUser(email, password);
		if(user != null) {
			ServletContext context = getServletContext();
			context.setAttribute("userRoleId", user.getRoleId());
			context.setAttribute("userId", user.getUserId());
//			RequestDispatcher d = request.getRequestDispatcher("/IndexHome");
			response.sendRedirect("IndexHome");
//			d.forward(request, response);
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("error_msg", "Invalid email or password");
			response.sendRedirect("login.jsp");
//			doGet(request, response);
			
		}

	}

}
