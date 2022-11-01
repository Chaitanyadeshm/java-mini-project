package com.cybage.hcs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
import com.cybage.utility.JDBCUtility;

/**
 * Servlet implementation class UpdateProfile
 */
@WebServlet("/updateProfile")
public class UpdateProfile extends HttpServlet {
	HCSService service = new HCSServiceImpl();

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
			RequestDispatcher d = request.getRequestDispatcher("update_profile.jsp");
			d.forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean success = false;
		Users user = new Users();
		int userId = Integer.parseInt(request.getParameter("user_id"));
		user.setUserId(userId);
		user.setFirstname(request.getParameter("firstName"));
		user.setLastname(request.getParameter("lastName"));
		user.setMobile(request.getParameter("mobile"));
		user.setCity(request.getParameter("city"));
		user.setEmail( request.getParameter("email"));
		success = service.updateUser(user);
		String url = "/showProfile?user_id=" + user.getUserId();
		if (success) {
			response.sendRedirect("showProfile?user_id="+ user.getUserId());
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("error_msg", "Could not update profile./n Try again later");
			response.sendRedirect("update_profile.jsp");

		}
	}

}
