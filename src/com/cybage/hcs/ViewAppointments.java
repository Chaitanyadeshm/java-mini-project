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
import com.cybage.service.HCSService;
import com.cybage.service.HCSServiceImpl;


@WebServlet("/viewAppointments")
public class ViewAppointments extends HttpServlet {
	
	HCSService service = new HCSServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DetailedAppointment> appointments = new ArrayList<DetailedAppointment>();
		Integer userIdFromTable = 0;
		Integer roleIdFromTable = 0;
		try {
			userIdFromTable = Integer.parseInt(request.getParameter("userId"));
			roleIdFromTable = Integer.parseInt(request.getParameter("roleId"));
		} catch (NumberFormatException e) {
			userIdFromTable = null;
			roleIdFromTable = null;
		}
		ServletContext context = getServletContext();
		Integer roleId = 0, userId = 0;
		if(userIdFromTable != null && roleIdFromTable != null) {
			userId = userIdFromTable;
			roleId = roleIdFromTable;
		}else {			
			roleId = (Integer) context.getAttribute("userRoleId");
			userId = (Integer) context.getAttribute("userId");
		}
		appointments = service.getALlDetailedAppointments(roleId, userId);
		
		context.setAttribute("appointments", appointments);
		RequestDispatcher d = request.getRequestDispatcher("view_appointments.jsp");
		
		d.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
