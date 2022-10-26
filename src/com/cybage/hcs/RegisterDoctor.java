package com.cybage.hcs;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cybage.modal.Specialization;
import com.cybage.modal.Users;
import com.cybage.service.AdminService;
import com.cybage.service.AdminServiceImpl;


@WebServlet("/registerDoctor")
public class RegisterDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	AdminService service = new AdminServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Specialization> specializations = service.getAllSpecialization();
		System.out.println("No. of specialization: " + specializations.size());
//		System.out.println("specialization: " + specializations);
		
		ServletContext context = getServletContext();
		context.setAttribute("specializations", specializations);
		
		RequestDispatcher d = request.getRequestDispatcher("register_doctor.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users user = new Users();
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String mobile =  request.getParameter("mobile");
		String city = request.getParameter("city");
		user.setFirstname(firstName);
		user.setLastname(lastName);
		user.setEmail(email);
		user.setMobile(Integer.parseInt(mobile));
		user.setCity(city);
		
		String[] doctorsSpecialization = request.getParameterValues("selected_specialization");
		try {
			boolean registerSuccess = service.registerDoctor(user, doctorsSpecialization);
			RequestDispatcher d = request.getRequestDispatcher("patients_table.jsp");
			d.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
//		doGet(request, response);
		
		
		
	}

}
