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

import com.cybage.modal.AllUsers;
import com.cybage.modal.Doctor;
import com.cybage.modal.Specialization;
import com.cybage.service.AdminService;
import com.cybage.service.AdminServiceImpl;


@WebServlet("/ShowAllUsers")
public class ShowAllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;       
	AdminService service = new AdminServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AllUsers> allUsers = service.getAllUsers();		
		ServletContext context = getServletContext();
		context.setAttribute("allUsers", allUsers);
		List<Doctor> doctors = new ArrayList<Doctor>();
		Doctor doctor = new Doctor();
		for(int i = 0; i < allUsers.size(); i++) {
			if(allUsers.get(i).getRoleName().contentEquals("Doctor")) {
				doctor = new Doctor();
				doctor.setUserId(allUsers.get(i).getUserId());
				doctor.setFirstname(allUsers.get(i).getFirstname());
				doctor.setLastname(allUsers.get(i).getLastname());
				doctor.setEmail(allUsers.get(i).getEmail());
				doctor.setMobile(allUsers.get(i).getMobile());
				doctor.setPassword(allUsers.get(i).getPassword());
				doctor.setActive(allUsers.get(i).getActive());
				doctor.setProfileUrl(allUsers.get(i).getProfileUrl());
				doctor.setCity(allUsers.get(i).getCity());
				doctor.setSpecializations(service.getDoctorsSpecializations(allUsers.get(i).getUserId()));
				doctors.add(doctor);
			}
		}
		context.setAttribute("doctors", doctors);
		RequestDispatcher d = request.getRequestDispatcher("show_users.jsp");
		d.forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	
	
	
	}

}
