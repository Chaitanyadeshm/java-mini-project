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
 * Servlet implementation class ChangePassword
 */
@WebServlet("/changePassword")
public class ChangePassword extends HttpServlet {
	HCSService service = new HCSServiceImpl();
//
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		int userIdParameter = Integer.parseInt(request.getParameter("user_id"));
		int userId = 0;
		if(userIdParameter == 0) {			
			userId = (int) context.getAttribute("userId");
		}else {
			userId = userIdParameter;
		}
		Users user = service.getUserById(userId);
		if(user != null) {
			context.setAttribute("userProfile", user);
			RequestDispatcher d = request.getRequestDispatcher("change_password.jsp");
			d.forward(request, response);
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean success = false;
		HttpSession session = request.getSession();
		Users user = new Users();
		int userId = Integer.parseInt(request.getParameter("user_id"));
		user.setUserId(userId);
		String newPassword = request.getParameter("new_password");
		String confirmPassword = request.getParameter("confirm_password");
		if(newPassword.equals(confirmPassword)) {			
			success = service.changePassword(userId, newPassword);
			if (success) {
				String url = "/showProfile?user_id=" + user.getUserId();
//				response.sendRedirect(url);
				RequestDispatcher d = request.getRequestDispatcher(url);
				d.forward(request, response);
			} else {
				session.setAttribute("error_msg", "Could not update password./n Try again later");
				response.sendRedirect("change_password.jsp");
			}
		}else {
			session = request.getSession();
			session.setAttribute("error_msg", "Check password and confirm password");
			response.sendRedirect("change_password.jsp");
		}
		
	}

}
