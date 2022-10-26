package com.cybage.hcs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.modal.Users;
import com.cybage.service.AdminService;
import com.cybage.service.AdminServiceImpl;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {
	AdminService service = new AdminServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context = getServletContext();
		context.removeAttribute("userRoleId");
		context.removeAttribute("userId");
		Integer roleId = 0;
		roleId = (Integer) context.getAttribute("userRoleId");
		String url = "login.jsp";
		if(roleId != null) {
			url = "/IndexHome";
		}
		RequestDispatcher d = request.getRequestDispatcher(url);
		d.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Users user = service.loginUser(email, password);
		if(user != null) {
			ServletContext context = getServletContext();
			context.setAttribute("userRoleId", user.getRoleId());
			context.setAttribute("userId", user.getUserId());
			
			RequestDispatcher d = request.getRequestDispatcher("/IndexHome");
			d.forward(request, response);
		}else {
			doGet(request, response);
			
		}

	}

}
