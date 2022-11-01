package com.cybage.hcs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.service.HCSService;
import com.cybage.service.HCSServiceImpl;

/**
 * Servlet implementation class AddPrescription
 */
@WebServlet("/addPrescription")
public class AddPrescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	HCSService service = new HCSServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String appointmentIdString = request.getParameter("appointmentId");
		String heading = request.getParameter("heading");	
		int appointmentId = Integer.parseInt(appointmentIdString);
		request.setAttribute("appointmentId", appointmentId);
		request.setAttribute("heading", heading);
		RequestDispatcher d = request.getRequestDispatcher("add_prescription.jsp");
		d.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String appointmentIdString = request.getParameter("appointmentId");
		int appointmentId = Integer.parseInt(appointmentIdString);
			
		String heading = request.getParameter("heading");
		RequestDispatcher d = null;
		String enteredText = request.getParameter("entered_text");
		if(heading.equals("Prescription")) {
			boolean success = service.addPrescription(appointmentId, enteredText);
			if(success) {
				d = request.getRequestDispatcher("/viewAppointments");
			}else {
				d = request.getRequestDispatcher("index.jsp");
			}
		}else  if(heading.equals("Feedback")){
			boolean success = service.addFeedback(appointmentId, enteredText);
			if(success) {
				d = request.getRequestDispatcher("/viewAppointments");
			}else {
				d = request.getRequestDispatcher("index.jsp");
				
			}
		}
		d.forward(request, response);
	
	
	}

}
