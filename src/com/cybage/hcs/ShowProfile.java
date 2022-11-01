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
import com.cybage.service.HCSService;
import com.cybage.service.HCSServiceImpl;

@WebServlet("/showProfile")
public class ShowProfile extends HttpServlet {
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
			context.setAttribute("userRoleId", user.getRoleId());
			context.setAttribute("userProfile", user);
			System.out.println("mobile: " + user.getMobile());
			RequestDispatcher d = request.getRequestDispatcher("user_profile.jsp");
			d.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
