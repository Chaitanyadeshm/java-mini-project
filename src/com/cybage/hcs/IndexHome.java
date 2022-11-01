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
import com.cybage.service.HCSService;
import com.cybage.service.HCSServiceImpl;

@WebServlet("/IndexHome")
public class IndexHome extends HttpServlet {
	HCSService service = new HCSServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<AllUsers> allUsers = service.getAllUsers();
		ServletContext context = getServletContext();
		request.setAttribute("allUsers", allUsers);
		Integer roleId = null;
		roleId = (Integer) context.getAttribute("userRoleId");
		if (roleId == null) {
			RequestDispatcher d = request.getRequestDispatcher("LoginUser");
			d.forward(request, response);
		} else {
			System.out.println("this is role id: " + roleId);
			try {
				List<Doctor> doctors = new ArrayList<Doctor>();
				Doctor doctor = new Doctor();
				for (int i = 0; i < allUsers.size(); i++) {
					if (allUsers.get(i).getRoleName().contentEquals("Doctor")) {
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
				request.setAttribute("doctors", doctors);
				if (roleId == 3) {
					List<Specialization> specializations = service.getAllSpecialization();
					System.out.println("No. of specialization: " + specializations.size());
					context.setAttribute("specializations", specializations);
				}
			} catch (Exception e) {
				roleId = 0;
				e.printStackTrace();
			}

			RequestDispatcher d = request.getRequestDispatcher("index.jsp");
			d.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String specializationParameter = request.getParameter("selected_specialization");
		Integer specializationId = Integer.parseInt(specializationParameter);
		System.out.println("this is specialization id: " + specializationParameter);
		getServletContext().removeAttribute("doctor_selected");
		request.setAttribute("specializationId", specializationId);

		request.setAttribute("doctorId", 0);
		response.sendRedirect("bookAppointment?doctorId=0&specializationId=" + specializationId);
//		RequestDispatcher d = request.getRequestDispatcher("/");
//		d.forward(request, response);

	}

}
