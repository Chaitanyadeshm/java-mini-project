package com.cybage.hcs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.modal.DetailedAppointment;
import com.cybage.service.AdminService;
import com.cybage.service.AdminServiceImpl;

/**
 * Servlet implementation class ViewAppointments
 */
@WebServlet("/viewAppointments")
public class ViewAppointments extends HttpServlet {
	
	AdminService service = new AdminServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DetailedAppointment> appointments = new ArrayList<DetailedAppointment>();
		ServletContext context = getServletContext();
		Integer roleId = 0, userId = 0;
		roleId = (Integer) context.getAttribute("userRoleId");
		userId = (Integer) context.getAttribute("userId");
		appointments = service.getALlDetailedAppointments(roleId, userId);
		
		context.setAttribute("appointments", appointments);
//		request.setAttribute("appointments", appointments);
		RequestDispatcher d = request.getRequestDispatcher("view_appointments.jsp");
		
		d.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
