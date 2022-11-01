package com.cybage.hcs;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.cybage.modal.Appointment;
import com.cybage.modal.Doctor;
import com.cybage.service.HCSService;
import com.cybage.service.HCSServiceImpl;

/**
 * Servlet implementation class BookAppointment
 */
@WebServlet("/bookAppointment")
public class BookAppointment extends HttpServlet {
	HCSService service = new HCSServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context = getServletContext();
		int specializationId = Integer.parseInt(request.getParameter("specializationId"));
		context.setAttribute("specializationId", specializationId);
		context.setAttribute("userId", context.getAttribute("userId"));
		System.out.println("idddddd: " + specializationId);

		int doctorId = Integer.parseInt(request.getParameter("doctorId"));
		System.out.println("this is doctor id: " + doctorId);
		try {
			if (doctorId > 0 ) {
				System.out.println("this is if: " );
				context.setAttribute("doctor_selected", doctorId);
				List<Appointment> doctorSpecificAppointments = new ArrayList<Appointment>();
				doctorSpecificAppointments = service.getDoctorsAppointment(doctorId);
			}

		} catch (Exception e) {
			System.out.println("this is catch");
			context.setAttribute("doctor_selected", 0);
			doctorId = 0;
			e.printStackTrace();
		}

		List<Doctor> specializedDoctors = service.getSpecializedDoctor(specializationId);

		System.out.println("length : " + specializedDoctors.size());


		context.setAttribute("specializedDoctors", specializedDoctors);
		System.out.println("this is doct selected: " + context.getAttribute("doctor_selected"));
		RequestDispatcher d = request.getRequestDispatcher("book_appointment.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		Appointment appointment = new Appointment();
		String dateString = request.getParameter("date");
		String timeString = request.getParameter("time");
		String patientsNotes = request.getParameter("patient_notes");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		Time sqlTime = null;
		try {
			date = sdf1.parse(dateString);
			sqlTime = Time.valueOf(timeString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		appointment.setPatientId( (Integer) context.getAttribute("userId"));
		appointment.setDoctorId( (Integer) context.getAttribute("doctor_selected"));
		appointment.setAppointmentTime(sqlTime);
		appointment.setAppointmentDate(sqlDate);
		appointment.setPatientsNotes(patientsNotes);
		context.setAttribute("doctor_selected", 0);
		boolean success = service.addAppointment(appointment);
		if(success) {
			RequestDispatcher d = request.getRequestDispatcher("/viewAppointments");
			d.forward(request, response);
		}else {
			RequestDispatcher d = request.getRequestDispatcher("index.jsp");
			d.forward(request, response);
		}
		
	}

}
