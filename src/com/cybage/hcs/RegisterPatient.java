package com.cybage.hcs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.User;

import com.cybage.modal.Users;
import com.cybage.service.HCSService;
import com.cybage.service.HCSServiceImpl;

/**
 * Servlet implementation class RegisterPatient
 */
@WebServlet("/registerPatient")
public class RegisterPatient extends HttpServlet {

	HCSService service = new HCSServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean success = false;
		Users user = new Users();
		user.setFirstname(request.getParameter("firstName"));
		user.setLastname(request.getParameter("lastName"));
		user.setMobile(request.getParameter("mobile"));
		user.setPassword(request.getParameter("password"));
		user.setCity(request.getParameter("city"));
		user.setEmail( request.getParameter("email"));
		success = service.registerPatient(user);
		if (success) {
			RequestDispatcher d = request.getRequestDispatcher("/LoginUser");
			d.forward(request, response);
		} else {
			doGet(request, response);

		}

	}

}
