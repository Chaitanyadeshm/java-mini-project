package com.cybage.service;

import java.sql.SQLException;
import java.util.List;
import com.cybage.dao.AdminDAO;
import com.cybage.dao.AdminDAOImpl;
import com.cybage.modal.AllUsers;
import com.cybage.modal.DetailedAppointment;
import com.cybage.modal.Roles;
import com.cybage.modal.Specialization;
import com.cybage.modal.Users;

public class AdminServiceImpl implements AdminService {

	AdminDAO adminDAO = new AdminDAOImpl();

	@Override
	public List<Roles> getAllRoles() {
		return adminDAO.getAllRoles();
	}
	
	@Override
	public List<Users> getSpecificUsers(String typeOfUser) {
		return adminDAO.getSpecificUsers(typeOfUser);
	}

	@Override
	public boolean registerDoctor(Users user, String[] doctorsSpecialization) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return adminDAO.registerDoctor(user, doctorsSpecialization);
	}

	@Override
	public List<Specialization> getAllSpecialization() {
		// TODO Auto-generated method stub
		return adminDAO.getAllSpecialization();
	}

	@Override
	public List<AllUsers> getAllUsers() {
		return adminDAO.getAllUsers();
	}

	@Override
	public List<String> getDoctorsSpecializations(int doctordId) {
		return adminDAO. getDoctorsSpecializations(doctordId);
	}

	@Override
	public Users loginUser(String email, String password) {
		return adminDAO.loginUser(email, password);
	}

	@Override
	public List<DetailedAppointment> getALlDetailedAppointments(int roleId, int userId) {
		return adminDAO.getALlDetailedAppointments(roleId, userId);
	}

	@Override
	public boolean updateAppointmentStatus(int appointmentId, String status) {
		return adminDAO.updateAppointmentStatus(appointmentId, status);
	}


}
