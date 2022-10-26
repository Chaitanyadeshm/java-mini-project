package com.cybage.hcs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.service.AdminService;
import com.cybage.service.AdminServiceImpl;

/**
 * Servlet implementation class UpdateAppointmentStatus
 */
@WebServlet("/updateAppointmentStatus")
public class UpdateAppointmentStatus extends HttpServlet {
	AdminService service = new AdminServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String status = request.getParameter("status");
		String oldStatus = request.getParameter("oldStatus");
		String appointmentId = request.getParameter("id");
		if(oldStatus.equalsIgnoreCase(status)) {
			RequestDispatcher d = request.getRequestDispatcher("viewAppointments");
			d.forward(request, response);
		}else {
			boolean success = service.updateAppointmentStatus(Integer.parseInt(appointmentId), status);
			if(success) {			
				RequestDispatcher d = request.getRequestDispatcher("viewAppointments");
				d.forward(request, response);
			}else {
				RequestDispatcher d = request.getRequestDispatcher("index.jsp");
				d.forward(request, response);
			}
		}
			
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		String status = request.getParameter("status");
//		System.out.println("post method status: " + status);
	
	}

}
